package com.njupt.designpattern.proxy;

/**
 * @author wall
 * @date 2019/7/4  21:01
 * @description
 */
public interface ProxyInterface {
    @TestProxy("我是注解")
    void say();
}
