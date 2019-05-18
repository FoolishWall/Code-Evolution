package com.njupt.zookeeperlock.run;

import com.njupt.zookeeperlock.order.OrderService;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wall
 * @date 2019/5/14  10:07
 * @description 利用同步屏障模拟多线程的并发
 */
public class SimManyThread {
    //测试
    public static void main(String[] args) {
        int currency = 20;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(currency);

        for (int i = 0 ; i < currency;i++){
            new Thread(()->{
                OrderService orderService = new OrderService();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                orderService.createOrder();
            }).start();
        }
    }
}
