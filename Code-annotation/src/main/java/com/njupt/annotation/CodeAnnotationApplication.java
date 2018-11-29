package com.njupt.annotation;

import com.njupt.annotation.Annotation.TestAnnotation;
import com.njupt.annotation.application.TestClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;

@SpringBootApplication
@SuppressWarnings("unchecked")
public class CodeAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeAnnotationApplication.class, args);


        //测试注解(利用反射获取注解信息)
        Class clazz = TestClass.class;
        try {
            Method method = clazz.getMethod("useAnnotation");
            System.out.println(method.getAnnotation(TestAnnotation.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
