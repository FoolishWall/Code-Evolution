package com.njupt.springcode.springmybatis.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author wall
 * @date 2019/7/5  10:59
 * @description FactoryBean学习
 */
public class FactoryBeanLearn implements FactoryBean {
    //②根据beanName知道bean为FactoryBean（即factoryBeanLearn）类型，
    //然后执行getObjectFromFactoryBean方法从FactoryBean中调用getObject()方法获取bean对象
    @Override
    public Object getObject() throws Exception {
        return new FactoryBeanServiceImpl();
    }
    //①循环Spring容器中所有的beanNames，再根据beanName获取对应的Bean实例，
    // 判断获取的Bean实例是不是FactoryBean类型的Bean，
    // 如果是，则调用Bean的getObjectType方法获取Class，
    // 将获取到的Class和传入的Class进行匹配，如果匹配到，则将此beanName和传入的Class建立一个映射关系。
    // 即FactoryBeanService类型对应的beanName为factoryBeanLearn
    //ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("");
    //FactoryBeanService beanService = cac.getBean(FactoryBeanService.class);
    //beanService.testFactoryBean();
    @Override
    public Class<?> getObjectType() {
        return FactoryBeanService.class;
    }
    //判断bean实例是否单例，默认为true
    // default boolean isSingleton() {
    //		return true;}
    @Override
    public boolean isSingleton() {
        return true;
    }
}
