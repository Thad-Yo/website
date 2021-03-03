package com.website.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.website.app.base.BaseResultBean;
import com.website.app.constants.ConstantsUtil;
import com.website.common.util.cache.RedisUtils;

/**
 * 
 * Token拦截器 对用户登录之后才有权查看的资源请求进行拦截，验证Token信息，验证通过放行，验证失败返回失败信息
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月17日
 * @see 上午9:49:04
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 * 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		BaseResultBean resultBean = new BaseResultBean();
		String token = request.getParameter("token");
		if (StringUtils.isBlank(token)) {
			resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_TOKEN_VALUE);
			resultBean.setMsg("用户登录失效，请重新登录");
		} else {
			String tokenValue = RedisUtils.get(token);
			if (StringUtils.isBlank(tokenValue)) {
				resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_TOKEN_VALUE);
				resultBean.setMsg("用户登录失效，请重新登录");
			} else {
				return true;
			}
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(JSON.toJSONString(resultBean));
		return false;
	}

}
