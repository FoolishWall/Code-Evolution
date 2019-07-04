package com.njupt.springcode.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/7/3  11:15
 * @description
 */
@Service
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 执行时机：调用initializeBean方法
     *先调用applyBeanPostProcessorsBeforeInitialization方法，
     * 执行每个BeanPostProcessor的postProcessBeforeInitialization，
     * 然后调用invokeInitMethods方法，执行bean的初始化方法，
     * 最后调用applyBeanPostProcessorsAfterInitialization方法，
     * 执行每个BeanPostProcessor的postProcessAfterInitialization方法。
     *
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("testClass")){
            System.out.println("before+初始化之前的操作");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("testClass")){
            System.out.println("after+初始化之后的操作");
        }
        return bean;
    }
}
