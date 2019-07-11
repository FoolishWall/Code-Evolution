package com.njupt.designpattern.composite;

/**
 * @author wall
 * @date 2019/7/11  10:41
 * @description
 */
public class School implements Component {
    @Override
    public String getName() {
        return "学校";
    }

    @Override
    public void action() {
        System.out.println(getName()+":业务逻辑");
    }
}
