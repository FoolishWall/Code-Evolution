package com.njupt.designpattern.decorator;

/**
 * @author wall
 * @date 2019/6/26  17:47
 * @description 装饰器，记录需要添加功能的类（记录component接口的实现类）
 */
public class Decorator implements Component{
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void change() {
        component.change();
    }
}
