package com.njupt.zookeeperlock.run;

import com.njupt.zookeeperlock.order.OrderServiceWithDistributelock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wall
 * @date 2019/5/17  11:35
 * @description 测试zookeeper的分布式锁
 */
public class TestZookeeperLock {
    //测试
    public static void main(String[] args) {
        int currency = 20;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(currency);

        for (int i = 0 ; i < currency;i++){
            new Thread(()->{
                OrderServiceWithDistributelock orderService = new OrderServiceWithDistributelock();
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
