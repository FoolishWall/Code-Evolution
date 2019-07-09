package com.njupt.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wall
 * @date 2019/7/4  21:00
 * @description
 */
public class ProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是动态代理类");
        System.out.println("获取方法上的注解:"+method.getAnnotation(TestProxy.class).value());
        return null;
    }
}
