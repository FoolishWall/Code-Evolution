package com.njupt.designpattern.handler;

/**
 * @author wall
 * @date 2019/6/26  11:42
 * @description
 */
abstract class Parent{
    void fun(){
        System.out.println("父类方法");
    }

    void template(){
        fun();
    }
}
class Child extends Parent{
    void fun(){
        System.out.println("子类方法");
    }
}

public class TestOverride {

    public static void main(String[] args) {
        //抽象类不能实例化
        //实例化子类
        Child child = new Child();
        //模板方法的核心
        //当子类覆写了父类的方法时，调用方法时会调用子类实现的方法
        child.template();
    }
}
