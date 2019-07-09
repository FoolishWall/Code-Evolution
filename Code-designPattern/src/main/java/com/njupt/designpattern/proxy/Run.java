package com.njupt.designpattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @author wall
 * @date 2019/7/4  21:05
 * @description
 */
public class Run {
    public static void main(String[] args) {
        ProxyInterface proxyInterface = (ProxyInterface) Proxy.newProxyInstance(Run.class.getClassLoader(),
                new Class[]{ProxyInterface.class},new ProxyHandler());
        proxyInterface.say();
    }
}
