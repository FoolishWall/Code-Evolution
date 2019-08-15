package com.njupt.springcode.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BeanInitOrderConfig {


    @Bean(initMethod = "initMethod" ,destroyMethod = "destroyMethod")
    public BeanInitOrder getBeanInitOrder(){
        return new BeanInitOrder();
    }

    @Bean
    public InitBeanHandleBeanPostProcessor getInitBeanHandle(){
        return new InitBeanHandleBeanPostProcessor();
    }

    @Bean
    public static InitBeanHandleBeanFactoryPostProcessor getInitBeanHandleBeanFactoryPostProcessor(){
        return new InitBeanHandleBeanFactoryPostProcessor();
    }

    @Bean
    public static MyInstantiationAwareBeanPostProcessor getMyInstantiationAwareBeanPostProcessor(){
        return new MyInstantiationAwareBeanPostProcessor();
    }
}
