package com.njupt.designpattern.command;

/**
 * @author wall
 * @date 2019/6/28  11:40
 * @description 定义命令
 */
public interface Command {
    void execute();
    void undo();
}
