package com.website.admin.log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.website.common.util.http.IpUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * 切点类
 */
@Aspect
@Order(5)
@Component
public class AdminWebLogAspect {
    // 注入Service用于把日志保存数据库

    // 本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(AdminWebLogAspect.class);

    // Controller层切点
    @Pointcut("execution(public * com.website.admin..*.*(..))")
    public void AdminWebLogAspect() {
        logger.info("层切点:AdminWebLogAspect");
    }

    @Before("AdminWebLogAspect()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("请求的URL : " + request.getRequestURL().toString());
        logger.info("请求的类型 : " + request.getMethod());
        logger.info("请求的用户 : " + SessionUtils.getLoginUserCd());
        logger.info("请求的IP地址 : " + IpUtils.getIpAddr(request));
        logger.info("请求的方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        StringBuilder sb = new StringBuilder();
        Enumeration<String> e = request.getParameterNames();
        JSONObject jsonObject = new JSONObject();
        if (e.hasMoreElements()) {
            while (e.hasMoreElements()) {
                String name = e.nextElement();
                String[] values = request.getParameterValues(name);
                if (values.length == 1) {
                    jsonObject.put(name, values[0]);
                } else {
                    JSONArray jsonArray = new JSONArray();
                    sb.append(name).append("[]={");
                    for (String value : values) {
                        jsonArray.add(value);
                    }

                    for (int i = 0; i < values.length; i++) {
                        if (i > 0)
                            sb.append(",");
                        sb.append(values[i]);
                    }
                    sb.append("}");
                }
                sb.append("  ");
            }
            sb.append("\n");
        }
        logger.info("请求的参数 : " + sb.toString());
    }

    @AfterReturning(returning = "ret", pointcut = "AdminWebLogAspect()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("返回结果 : " + ret);
    }


    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "AdminWebLogAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        // 读取session中的用户
        LoginUserInfo currentUser = SessionUtils.getLoginUserInfo();

        // 获取用户请求方法的参数并序列化为JSON格式字符串 请求的参数
        String params = "";
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            params = JSONObject.toJSONString(joinPoint.getArgs());
        }
        try {
            // 异常代码
            String exceptionCode = e.getClass().getName();
            // 异常信息
            String exceptionMessage = e.getMessage();
            // 异常方法
            String exceptionMethod = (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
            // 请求人
            String rquestUserId = currentUser.getUserId() + "(" + currentUser.getUserName() + ")";
            // 请求的IP地址
            String ipAddress = IpUtils.getIpAddr(request);
            logger.error("异常方法:{} 异常代码:{} 异常信息:{} 参数:{} 请求人:{} 请求的IP地址:{}", exceptionMethod, exceptionCode, exceptionMessage, params, rquestUserId, ipAddress);
        } catch (Exception ex) {
            logger.error("异常信息:{}", ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    /**
     * 日志的环绕通知
     *
     * @param joinpoint
     * @return
     */
    @Around(value = "AdminWebLogAspect()")
    public Object aroundLog(ProceedingJoinPoint joinpoint) throws Throwable {
        Object result = null;
        try {
            // log开始
            long start = System.currentTimeMillis();
            logger.info("日志开始 :====================================>>>" + start);
            //有返回参数 则需返回值
            result = joinpoint.proceed();
            long end = System.currentTimeMillis();
            logger.info("执行方法耗费时间 :" + (end - start) + " 毫秒");
            logger.info("日志结束 :====================================>>>" + end);
        } catch (Throwable t) {
            logger.error("日志的环绕通知发生异常：" + t.getCause());
            t.printStackTrace();
            throw t;
        }
        return result;
    }
}