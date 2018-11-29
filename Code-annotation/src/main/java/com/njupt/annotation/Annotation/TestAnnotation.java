package com.njupt.annotation.Annotation;

import java.lang.annotation.*;

/**
 * @author wall
 * @date 2018/11/29  9:43
 * @description 方法上的注解
 */
/*
    用于指定被修饰的Annotation能用于修饰哪些程序单元
 */
@Target(ElementType.METHOD)
/*
    用于指定被修饰的Annotation可以保留多长时间
    RetentionPolicy.RUNTIME:编译器将把Annotation记录在class文件中。
    当运行java程序时，JVM也可获取Annotation信息，程序可以通过反射获取该Annotation信息
 */
@Retention(RetentionPolicy.RUNTIME)
/*
    用于指定被修饰的Annotation将被javadoc工具提取成文档。即说明该注解将被包含在javadoc中。
 */
@Documented
//这是一个标识注解
public @interface TestAnnotation {
    String value();
}
