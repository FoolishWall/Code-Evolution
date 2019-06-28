package com.njupt.designpattern.command;

/**
 * @author wall
 * @date 2019/6/28  11:32
 * @description 命令模式：封装命令，对各个命令进行控制，注入命令command
 *
 * 命令模式的初衷：对命令请求者（Invoker）和命令实现者（Receiver）的解耦，方便对命令进行各种控制。
 *
 * 打个比方：现在我们要对ConcreteCommandA与ConcreteCommandB以及其他一系列命令进行日志记录，并且两个命令之间的操作间隔不能大于1秒。
 */
public class Invoke {
    Command command;

    public Invoke(Command command) {
        this.command = command;
    }
    //执行命令
    public void executeCommand(){
        command.execute();
    }
    //取消执行命令
    public void undoCommand(){
        command.undo();
    }
}
