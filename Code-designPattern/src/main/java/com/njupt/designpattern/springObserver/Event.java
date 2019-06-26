package com.njupt.designpattern.springObserver;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/6/26  9:43
 * @description 定义事件，将事件与监听器联系起来
 */
public class Event extends ApplicationEvent {
    public Event(Object source) {
        super(source);
    }
}
