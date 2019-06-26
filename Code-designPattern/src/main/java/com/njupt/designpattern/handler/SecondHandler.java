package com.njupt.designpattern.handler;

import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/6/26  15:11
 * @description
 */
@Service
public class SecondHandler extends AppHandler {
    @Override
    protected String getClassName() {
        return "责任链的第二链";
    }

    @Override
    protected String echo() {
        return getClassName()+":的逻辑操作";
    }
}
