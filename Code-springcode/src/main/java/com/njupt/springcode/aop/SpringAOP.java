package com.njupt.springcode.aop;

import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wall
 * @date 2019/7/20  10:05
 * @description
 */
public class SpringAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        Calculate calculate = (Calculate) annotationConfigApplicationContext.getBean("calculateImp");
        calculate.add();
    }
}
