package com.njupt.mybatisintercept.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Locale;
import java.util.Properties;

/**
 * @author wall
 * @date 2019/6/20  21:26
 * @description
 */
@Intercepts({@Signature(type = Executor.class,method = "update",args = {MappedStatement.class,Object.class}),
        @Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
public class MybatisInterceptor implements Interceptor {

    /**正则匹配 insert、delete、update操作*/
    private static final String REGEX = ".*insert\\\\u0020.*|.*delete\\\\u0020.*|.*update\\\\u0020.*";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //获取执行参数
        Object[] objects = invocation.getArgs();
        MappedStatement ms = (MappedStatement) objects[0];

        BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
        String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replace("[\\t\\n\\r]", " ");
        System.out.println("打印SQL语句"+sql);
        //如果是insert、delete、update操作 使用主库
        if (sql.matches(REGEX)) {
            System.out.println("拦截执行数据库的请求：写请求");
        } else {
            //使用从库
            System.out.println("拦截执行数据库的请求：读请求");
        }
        //继续执行逻辑
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        //获取代理权
        if (o instanceof Executor){
        //如果是Executor（执行增删改查操作），则拦截下来
            return Plugin.wrap(o,this);
        }else {
            return o;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        //读取mybatis配置文件中属性
    }
}
