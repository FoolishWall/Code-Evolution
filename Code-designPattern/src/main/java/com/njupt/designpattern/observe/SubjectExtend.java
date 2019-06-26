package com.njupt.designpattern.observe;

/**
 * @author wall
 * @date 2019/6/25  20:45
 * @description
 */
public class SubjectExtend extends Subject{
    public void run(){
        System.out.println("被观察者发布消息");
        //调用父类方法，通知观察者，被观察者有动态
        notifyObserve();
    }
}
