package com.njupt.springcode.aop;

/**
 * @author wall
 * @date 2019/7/20  15:31
 * @description
 */
public class CalculateImp implements Calculate {
    @Override
    public void add() {
        System.out.println("加法");
    }
}
