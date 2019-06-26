package com.njupt.designpattern.handler;

/**
 * @author wall
 * @date 2019/6/26  14:57
 * @description 责任链模式的处理器
 */
//抽象类
public abstract class AppHandler {
    private AppHandler nextAppHandler;
    public void handleMessage(String selector){
        if (this.getClassName().equals(selector)){
            System.out.println(this.echo());
        }else {
            if (this.nextAppHandler!=null){
                this.nextAppHandler.handleMessage(selector);
            }
        }
    }

    public void setNextAppHandler(AppHandler nextAppHandler) {
        this.nextAppHandler = nextAppHandler;
    }

    //抽象方法，方式所代表的链
    protected abstract String getClassName();
    //抽象方法，定义了具体的操作
    protected abstract String echo();

}
