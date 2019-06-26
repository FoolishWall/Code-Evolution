package com.njupt.designpattern.observe;

/**
 * @author wall
 * @date 2019/6/25  20:34
 * @description 观察者
 */
public interface Observe {
    //获取观察者的名称
    String getName();
    //观察者接收到消息，执行操作
    void listener();
}
