package com.njupt.designpattern.decorator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wall
 * @date 2019/6/27  15:56
 * @description
 */
public class TestFinal {
    final int i ;
    TestFinal obj;
    public TestFinal() {
        this.i = 1;
        obj = this;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    }
}
