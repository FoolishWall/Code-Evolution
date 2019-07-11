package com.njupt.designpattern.composite;

/**
 * @author wall
 * @date 2019/7/11  10:43
 * @description
 */
public class CClass implements Component {
    @Override
    public String getName() {
        return "班级";
    }

    @Override
    public void action() {
        System.out.println(getName()+":业务逻辑");
    }
}
