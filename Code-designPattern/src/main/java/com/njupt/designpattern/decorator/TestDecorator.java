package com.njupt.designpattern.decorator;

/**
 * @author wall
 * @date 2019/6/26  17:58
 * @description
 */
public class TestDecorator {
    //测试
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.change();
        System.out.println("======");
        //扩展功能A
        Component componentA = new ConcreteDecoratorA(component);
        componentA.change();
        System.out.println("======");
        //扩展功能B
        Component componentB = new ConcreteDecoratorB(component);
        componentB.change();
        System.out.println("======");
        //同时扩展功能A,B
        Component componentAB = new ConcreteDecoratorB(componentA);
        componentAB.change();
    }
}
