package com.njupt.newjava.base;

/**
 * @author wall
 * @date 2019/8/23  20:43
 * @description
 */
public class TestOverride {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.showText();
    }
}
class SuperClass {
    public int i = 1;
    SuperClass(){
        showText();
    }
    public void showText(){
        System.out.println("父类中的方法");
    }
}

class SubClass extends SuperClass{
    public void showText(){
        System.out.println("子类中的方法");
    }
}
