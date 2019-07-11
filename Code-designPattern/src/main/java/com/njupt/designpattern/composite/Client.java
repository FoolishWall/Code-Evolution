package com.njupt.designpattern.composite;

/**
 * @author wall
 * @date 2019/7/11  10:47
 * @description
 */
public class Client {
    public static void main(String[] args) {
        CompositeClass school = new CompositeClass();
        school.addChild(new Department());
        CompositeClass department = new CompositeClass();
        department.addChild(new CClass());

        school.getChild();
        department.getChild();
    }
}
