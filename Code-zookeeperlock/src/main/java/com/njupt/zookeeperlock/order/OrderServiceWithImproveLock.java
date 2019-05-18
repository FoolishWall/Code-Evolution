package com.njupt.zookeeperlock.order;

import com.njupt.zookeeperlock.zkclient.ZKDistributeImproveLock;

/**
 * @author wall
 * @date 2019/5/18  10:56
 * @description
 */
public class OrderServiceWithImproveLock {
    private static CreateOrderID createOrderID = new CreateOrderID();

    //调用订单生成类生成订单号
    public void createOrder(){
        ZKDistributeImproveLock lock = new ZKDistributeImproveLock("/wall");
        try {
            lock.lock();
            createOrderID.getOrderID();

            //...业务处理代码
        } finally {
            lock.unlock();
        }
    }
}
