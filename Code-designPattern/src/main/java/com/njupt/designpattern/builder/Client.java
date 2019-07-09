package com.njupt.designpattern.builder;

/**
 * @author wall
 * @date 2019/7/9  21:02
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director(new BuildChina());
        System.out.println(director.build());
    }
}
