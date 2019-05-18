package com.njupt.zookeeperlock.order;

import com.njupt.zookeeperlock.zkclient.ZKDistributeLock;

/**
 * @author wall
 * @date 2019/5/17  12:11
 * @description
 */
public class OrderServiceWithDistributelock {
    private static CreateOrderID createOrderID = new CreateOrderID();

    //调用订单生成类生成订单号
    public void createOrder(){
        ZKDistributeLock lock = new ZKDistributeLock("/wall");
        try {
            lock.lock();
            createOrderID.getOrderID();
        } finally {
            lock.unlock();
        }
    }
}
