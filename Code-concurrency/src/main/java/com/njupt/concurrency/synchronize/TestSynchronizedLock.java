package com.njupt.concurrency.synchronize;

/**
 * @author wall
 * @date 2019/8/15  14:42
 * @description 测试synchronized锁住的对象类型
 */
public class TestSynchronizedLock {
    //测试
    public static void main(String[] args) {
        //启动两个线程,创建两个实例对象。
        new Thread(new A()).start();
        new Thread(new A()).start();
    }
}


