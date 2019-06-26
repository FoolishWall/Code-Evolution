package com.njupt.designpattern.springObserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/6/26  9:52
 * @description
 */
@Service
public class DetailEvent {
    //注入容器
    @Autowired
    ApplicationContext applicationContext;

    public void run(){
        System.out.println("创建订单");
        applicationContext.publishEvent(new Event(""));
    }
}
