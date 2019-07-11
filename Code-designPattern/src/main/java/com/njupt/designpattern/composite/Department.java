package com.njupt.designpattern.composite;

/**
 * @author wall
 * @date 2019/7/11  10:42
 * @description
 */
public class Department implements Component {
    @Override
    public String getName() {
        return "学院";
    }

    @Override
    public void action() {
        System.out.println(getName()+":业务逻辑");
    }
}
