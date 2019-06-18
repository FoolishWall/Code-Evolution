package com.njupt.concurrency.blockingqueue;

import com.njupt.concurrency.condition.NextToNextPrint;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wall
 * @date 2019/6/18  21:25
 * @description 使用阻塞队列实现生产者，消费者
 */
public class LinkedBlockingQueuePrint {
    //不指定大小，默认为Integer.MAX_VALUE，这里指定大小为1
    private static LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<Integer>(1);
    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }


    //定义两个线程
    static class Thread1 implements Runnable{
        @Override
        public void run() {
            for (int i = 0 ; i <= 100; i =i + 2){
                try {
                    linkedBlockingQueue.put(i);
                    System.out.println(Thread.currentThread().getName()+"--"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Thread2 implements Runnable{
        @Override
        public void run() {
            for (int i = 1 ; i <= 99; i =i + 2){
                try {
                    linkedBlockingQueue.take();
                    System.out.println(Thread.currentThread().getName()+"--"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
