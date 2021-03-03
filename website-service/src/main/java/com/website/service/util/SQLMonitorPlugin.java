package com.website.service.util;import com.alibaba.fastjson.JSONObject;import com.website.common.util.properties.PropertyUtil;import org.apache.commons.lang.StringUtils;import org.apache.commons.lang3.math.NumberUtils;import org.apache.ibatis.executor.Executor;import org.apache.ibatis.mapping.BoundSql;import org.apache.ibatis.mapping.MappedStatement;import org.apache.ibatis.plugin.*;import org.apache.ibatis.session.ResultHandler;import org.apache.ibatis.session.RowBounds;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import java.util.Collection;import java.util.Properties;/** * SQL监控，Mybatis插件 * <p>默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：</p> * <ul><li>拦截执行器的方法，Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)</li> * <li>拦截参数的处理，ParameterHandler (getParameterObject, setParameters)</li> * <li>拦截结果集的处理，ResultSetHandler (handleResultSets, handleOutputParameters)</li> * <li>拦截Sql语法构建的处理，StatementHandler (prepare, parameterize, batch, update, query)</li></ul> * * @author BBF */@Intercepts({        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,                Object.class}),        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class,                Object.class, RowBounds.class, ResultHandler.class})})public class SQLMonitorPlugin implements Interceptor {    private static final Logger logger = LoggerFactory.getLogger(SQLMonitorPlugin.class);    /**     * 是否监控显示SQL     */    private static boolean SHOWSQL;    /**     * 慢SQL时间     */    private static int SLOWER;    private static int MAXCOUNT;    static {        String _showSql = PropertyUtil.getSystemResourcesPropertieValue("System.db.showsql");        SHOWSQL = StringUtils.equals("1", _showSql);        SLOWER = NumberUtils.toInt(PropertyUtil.getSystemResourcesPropertieValue("System.db.slower"), 3000);        MAXCOUNT = NumberUtils.toInt(PropertyUtil.getSystemResourcesPropertieValue("System.db.maxCount"), 50);    }    public Object intercept(Invocation invocation) throws Throwable {        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];        //请求参数        Object parameter = null;        if (1 < invocation.getArgs().length) {            parameter = invocation.getArgs()[1];        }        BoundSql boundSql = mappedStatement.getBoundSql(parameter);        String sql = boundSql.getSql();        String resource = mappedStatement.getResource();        //去除sql文中的换行        sql = sql.replace("\n", StringUtils.EMPTY).replaceAll("\\s+", " ");        if (SHOWSQL) {            logger.debug(this.getClass().getName(), "", "[SQLMonitorPlugin]SQL监控：{" + resource + "}，sql：{" + sql + "}，参数：{" + JSONObject.toJSON(parameter) + "}");        }        try {            long start = System.currentTimeMillis();            Object e = invocation.proceed();            long end = System.currentTimeMillis();            if (end - start > SLOWER) {                logger.warn(this.getClass().getName(), "", "[SQLMonitorPlugin]>>>>>>>>>>>   慢  <<<<<<<<<<<<<SQL监控 {" + (end - start) + "} 毫秒。{" + resource + "}，sql：{" + sql + "}，参数：{" + JSONObject.toJSON(parameter) + "}");            }            if (e instanceof Collection && ((Collection<?>) e).size() > MAXCOUNT) {                logger.debug(this.getClass().getName(), "", "[SQLMonitorInterceptor]SQL大集合监控 {" + resource + "} {" + mappedStatement.getId() + "} {" + Integer.valueOf(((Collection<?>) e).size()) + "} ");            }            return e;        } catch (Exception e) {            logger.error(this.getClass().getName(), "", "[SQLMonitorInterceptor]SQL执行出错 {" + resource + "} {" + sql + "} ", e);            logger.error(this.getClass().getName(), "", "[SQLMonitorInterceptor]SQL执行出错 参数： {" + JSONObject.toJSON(parameter) + "} ");            throw e;        }    }    public Object plugin(Object target) {        return Plugin.wrap(target, this);    }    public void setProperties(Properties properties) {    }}