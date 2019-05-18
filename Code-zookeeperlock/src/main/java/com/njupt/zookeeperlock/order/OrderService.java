package com.njupt.zookeeperlock.order;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wall
 * @date 2019/5/14  10:55
 * @description 订单服务类
 */
public class OrderService {
    private static CreateOrderID createOrderID = new CreateOrderID();
    private ReentrantLock lock = new ReentrantLock();
    //调用订单生成类生成订单号
    public void createOrder(){
        try {
            lock.lock();
            createOrderID.getOrderID();
        } finally {
            lock.unlock();
        }
    }
}
