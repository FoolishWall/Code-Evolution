package com.njupt.springcode.springmybatis;
import org.apache.ibatis.annotations.Select;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wall
 * @date 2019/7/4  20:26
 * @description
 */
public class MybatisHandler implements InvocationHandler {
    /**
     * @param proxy 代理对象
     * @param method 代理方法
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法上注解的值
        System.out.println("获取SQL语句:"+ method.getAnnotation(Select.class).value()[0]);
        System.out.println("执行JDBC操作");
        return null;
    }
}
