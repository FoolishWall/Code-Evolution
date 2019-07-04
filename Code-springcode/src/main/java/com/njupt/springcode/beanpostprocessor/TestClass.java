package com.njupt.springcode.beanpostprocessor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/7/3  11:19
 * @description
 */
@Service
public class TestClass implements InitializingBean {
    private String des;

    public TestClass() {
        System.out.println("===TestClass的构造方法===");
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("===实现InitializingBean接口的afterPropertiesSet方法===");
    }
}
