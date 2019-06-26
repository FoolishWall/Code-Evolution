package com.njupt.annotation.reflect;
import com.njupt.annotation.Annotation.TestAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author wall
 * @date 2019/6/24  10:57
 * @description 通过反射获取注解
 */
public class GetAnnotation {

    public static void main(String[] args) {
        try {
            //获取类
            Class clazz = Class.forName("com.njupt.annotation.application.TestClass");
            //获取指定方法
            Method method = clazz.getDeclaredMethod("useAnnotation");
            //获取方法上的注解
            Annotation annotation = method.getAnnotation(TestAnnotation.class);
            System.out.println(annotation);
            //获取注解的属性值
            System.out.println(((TestAnnotation) annotation).value());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        //AnnotationConfigApplicationContext：从一个或多个基于 Java 的配置类中加载 Spring 应用上下文。
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    }



}
