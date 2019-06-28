package com.njupt.designpattern.decorator;

/**
 * @author wall
 * @date 2019/6/26  17:56
 * @description
 */
public class ConcreteComponent implements Component {

    @Override
    public void change() {
        System.out.println("需要扩展功能类的业务逻辑");
    }
}
