package com.njupt.springcode.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class InitBeanHandleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition getBeanInitOrder = beanFactory.getBeanDefinition("getBeanInitOrder");
        MutablePropertyValues propertyValues = getBeanInitOrder.getPropertyValues();
        propertyValues.addPropertyValue("name", "mateEgg");
        System.out.println("执行BeanFactoryPostProcessor的postProcessBeanFactory方法");
    }
}
