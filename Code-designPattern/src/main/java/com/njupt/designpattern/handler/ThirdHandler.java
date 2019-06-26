package com.njupt.designpattern.handler;

import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/6/26  15:26
 * @description
 */
@Service
public class ThirdHandler extends AppHandler {
    @Override
    protected String getClassName() {
        return "责任链的第三链";
    }

    @Override
    protected String echo() {
        return getClassName()+":的逻辑操作";
    }
}
