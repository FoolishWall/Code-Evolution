package com.njupt.concurrency.synchronize;

/**
 * @author wall
 * @date 2019/8/15  15:07
 * @description
 */
public class A implements Runnable{
    //synchronized修饰静态方法，锁住的是类对象
    public static synchronized  void methodA(){
        System.out.println("调用方法A");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        methodA();
    }
}
