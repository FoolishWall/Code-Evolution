package com.njupt.zookeeperlock.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * @author wall
 * @date 2019/5/16  11:49
 * @description zookeeper监视器
 */
public class ZkWatcher {
    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("localhost:2181");
        zkClient.setZkSerializer(new MyZkSerializer());
        zkClient.subscribeDataChanges("/wall/tao", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("===节点数据发生变化"+s);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("---收到节点被删除---"+s);
            }
        });

        try {
            Thread.sleep(1000*60*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
