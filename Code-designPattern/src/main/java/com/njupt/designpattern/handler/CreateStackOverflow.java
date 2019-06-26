package com.njupt.designpattern.handler;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author wall
 * @date 2019/6/26  16:03
 * @description
 */
public class CreateStackOverflow {
    public static void main(String[] args) {
        fun();
    }
    //无限循环调用
    private static void fun(){
        while (true){
            fun();
        }
    }
}
