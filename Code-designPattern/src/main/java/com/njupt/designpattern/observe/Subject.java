package com.njupt.designpattern.observe;

import java.util.ArrayList;

/**
 * @author wall
 * @date 2019/6/25  20:31
 * @description 被观察者的抽象类
 */
public abstract class Subject {
    //利用List集合保存观察者,类变量
    private ArrayList<Observe> list = new ArrayList<>();
    //1.注册观察者
    public void register(Observe observe){
        list.add(observe);
        System.out.println(observe.getName()+"：注册成功");
    }
    //2.移除观察者
    public void delete(Observe observe){
        list.remove(observe);
    }
    //3.通知观察者
    public void notifyObserve(){
        //遍历list，执行listener方法
        list.forEach(Observe::listener);
    }
}
