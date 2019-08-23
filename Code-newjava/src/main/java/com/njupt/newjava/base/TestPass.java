package com.njupt.newjava.base;

/**
 * @author wall
 * @date 2019/8/23  21:28
 * @description
 */
public class TestPass {
    public static void main(String[] args) {
        String string = "string";
        TestDemo testDemo = new TestDemo("class");
        testClass(testDemo);
        System.out.println(testDemo.string);
        testString(string);
        System.out.println(string);
    }
    //引用传递
    public static void testClass(TestDemo testDemo){
        testDemo.string = "修改类中的属性";
        testDemo.string = "引用传递";
    }
    //值传递
    public static void testString(String string){
        string = "修改string的值";
        System.out.println(string);
    }
}

class TestDemo{
    public String string;
    TestDemo(String string){
      this.string = string;
    }
}
