package com.njupt.designpattern.command;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author wall
 * @date 2019/6/28  11:52
 * @description
 */
public class Client {
    public static void main(String[] args) {
        //命令的执行者
        Receiver receiver = new Receiver();
        ConcreteCommandA concreteCommandA = new ConcreteCommandA(receiver);
        Invoke invoke = new Invoke(concreteCommandA);
        //执行命令
        invoke.executeCommand();
        //取消执行
        invoke.undoCommand();
    }
}
