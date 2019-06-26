package com.njupt.designpattern.observe;

/**
 * @author wall
 * @date 2019/6/25  20:43
 * @description
 */
public class Observer2 implements Observe {
    @Override
    public String getName() {
        return "观察者二号";
    }

    @Override
    public void listener() {
        System.out.println("收到通知:"+getName()+"执行操作");
    }
}
