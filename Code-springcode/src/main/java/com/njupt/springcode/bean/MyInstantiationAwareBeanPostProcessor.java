package com.njupt.springcode.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author wall
 * @date 2019/7/3  10:43
 * @description
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    /**
     *执行时机：实例化前执行，执行createBean，调用开端的resolveBeforeInstantiation方法，这个方法可以返回bean的一个代理类
     */
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("getBeanInitOrder")) {
            System.out.println("执行InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation方法");
        }
        return null;
    }
    /**
     *执行时机：给bean填充属性，执行populateBean方法时，
     */
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.equals("getBeanInitOrder")) {
            System.out.println("执行InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation方法");
        }
        return true;
    }
    /**
     *执行时机：当postProcessAfterInstantiation返回true，设置bean中的属性
     */
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {

        return null;
    }

    /**
     * BeanPostProcessor接口的两个方法：在初始化前后执行
     *
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
