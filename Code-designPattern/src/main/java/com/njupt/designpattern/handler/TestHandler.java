package com.njupt.designpattern.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/6/26  15:20
 * @description
 */
@Service
public class TestHandler {
    @Autowired
    StartHandler startHandler;
    @Autowired
    SecondHandler secondHandler;
    @Autowired
    ThirdHandler thirdHandler;

    public void run(String selector){
        startHandler.setNextAppHandler(secondHandler);
        secondHandler.setNextAppHandler(thirdHandler);
        startHandler.handleMessage(selector);
    }
}
