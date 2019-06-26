package com.njupt.designpattern.springObserver;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/6/26  9:45
 * @description
 */

//添加注解，将监听器注入IOC容器中
@Service
public class Listener1 implements SmartApplicationListener {
    //指定监听的事件
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == Event.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }
    //指定执行顺序
    @Override
    public int getOrder() {
        return 23;
    }
    //定义操作
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("短信通知");
    }
}
