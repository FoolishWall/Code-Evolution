package com.njupt.springcode.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanInitOrder implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    private String name;

    public BeanInitOrder() {
        System.out.println("执行构造方法");
    }

    public void initMethod() {
        System.out.println("执行bean定义的initMethod方法");
    }

    public void destroyMethod() {
        System.out.println("执行bean定义的destroyMethod方法");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("执行PostConstruct方法");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("执行PreDestroy方法");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("获取BeanFactory："+beanFactory);
    }

    public void setBeanName(String s) {
        System.out.println("获取BeanName："+s);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("注入ApplicationContext");
    }


    public void destroy() throws Exception {
        System.out.println("执行DisposableBean的destroy方法");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("执行InitializingBean的afterPropertiesSet方法");
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

}
