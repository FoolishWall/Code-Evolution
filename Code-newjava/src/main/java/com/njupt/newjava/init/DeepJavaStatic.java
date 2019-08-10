package com.njupt.newjava.init;

/**
 * @author wall
 * @date 2019/7/30  19:57
 * @description
 */
public class DeepJavaStatic {
    public static void main(String[] args) {
//        InnerTest.getStatic();
//        System.out.println(InnerTest.sex);
        InnerTest clazz = new InnerTest("s");
    }
}

class InnerTest{
    //实例变量
    private String name;
    //类变量
    public static  String sex;
    static {
        System.out.println("执行静态代码块");
    }
    public InnerTest(String name) {
        System.out.println("执行对象构造器");
        this.name = name;
    }

    public static void getStatic(){
        System.out.println("访问类的静态方法");
    }
}
