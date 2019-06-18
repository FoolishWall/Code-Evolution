package com.njupt.concurrency.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wall
 * @date 2019/6/18  21:05
 * @description 两个线程交替打印
 */
public class NextToNextPrint {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }
    //定义两个线程
    static class Thread1 implements Runnable{
        @Override
        public void run() {
            for (int i = 0 ; i <= 100; i =i + 2){
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"---"+i);
                try {
                    condition2.signal();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class Thread2 implements Runnable{
        @Override
        public void run() {
            for (int i = 1 ; i <= 99; i =i + 2){
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"---"+i);
                try {
                    condition1.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
