package com.njupt.zookeeperlock.run;

import com.njupt.zookeeperlock.order.OrderServiceWithImproveLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wall
 * @date 2019/5/18  10:57
 * @description
 */
public class TestZookeeperImproveLock {
    //测试
    public static void main(String[] args) {
        int currency = 20;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(currency);

        for (int i = 0 ; i < currency;i++){
            new Thread(()->{
                OrderServiceWithImproveLock orderService = new OrderServiceWithImproveLock();
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
