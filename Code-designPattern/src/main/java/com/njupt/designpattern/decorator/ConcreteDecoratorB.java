package com.njupt.designpattern.decorator;

/**
 * @author wall
 * @date 2019/6/26  17:54
 * @description
 */
public class ConcreteDecoratorB extends Decorator{
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void change() {
        super.change();
        System.out.println("拓展功能B类的业务逻辑");
    }
}
