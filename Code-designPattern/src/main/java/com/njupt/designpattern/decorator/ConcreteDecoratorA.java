package com.njupt.designpattern.decorator;

/**
 * @author wall
 * @date 2019/6/26  17:50
 * @description 继承装饰器类，拓展功能
 */
public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    //覆写拓展功能的方法
    @Override
    public void change() {
        //先调用父类的功能
        super.change();
        System.out.println("拓展功能A类的业务逻辑");
    }
}
