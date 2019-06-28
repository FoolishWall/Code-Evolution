package com.njupt.designpattern.command;

/**
 * @author wall
 * @date 2019/6/28  11:42
 * @description 聚合实际命令的操作Receiver，实现命令接口
 */
public class ConcreteCommandA implements Command{
    Receiver receiver;

    public ConcreteCommandA(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.trueDo();
    }

    @Override
    public void undo() {
        receiver.unDo();
    }
}
