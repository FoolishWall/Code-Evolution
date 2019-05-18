package com.njupt.zookeeperlock.order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wall
 * @date 2019/5/14  10:10
 * @description 创建唯一的订单编号
 */
public class CreateOrderID {
    private int i = 0;

    /**
     * 利用原子类生成订单ID
     * @return
     */
    public void getOrderID(){
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        i++;
        System.out.println(s.format(date)+"****"+i);
    }
}
