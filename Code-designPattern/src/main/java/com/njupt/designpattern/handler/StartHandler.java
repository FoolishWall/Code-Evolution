package com.njupt.designpattern.handler;

import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/6/26  15:09
 * @description
 */
@Service
public class StartHandler extends AppHandler {
    @Override
    protected String getClassName() {
        return "责任链的开始端";
    }

    @Override
    protected String echo() {
        return getClassName()+":逻辑操作";
    }
}
