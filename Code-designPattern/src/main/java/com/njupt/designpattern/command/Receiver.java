package com.njupt.designpattern.command;

/**
 * @author wall
 * @date 2019/6/28  11:37
 * @description 命令模式：命令的执行者
 */
public class Receiver {
    public void trueDo(){
        System.out.println("我是实际操作");
    }
    public void unDo(){
        System.out.println("真正取消命令的操作");
    }
}
