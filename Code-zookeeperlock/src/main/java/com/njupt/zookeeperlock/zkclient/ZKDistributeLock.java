package com.njupt.zookeeperlock.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author wall
 * @date 2019/5/17  10:56
 * @description 基于zookeeper监视器实现的分布式锁
 */
public class ZKDistributeLock implements Lock {

    private String lockPath;
    private ZkClient zkClient;

    public ZKDistributeLock(String lockPath) {
        this.lockPath = lockPath;
        this.zkClient = new ZkClient("localhost:2181");
        zkClient.setZkSerializer(new MyZkSerializer());
    }

    @Override
    public void lock() {//如果获取不到锁，阻塞线程
        if (!tryLock()){
            //如果没有获取锁，阻塞自己
            waitForLock();
            //再次尝试获取锁
            lock();
        }
    }

    public void waitForLock(){
        CountDownLatch countDownLatch = new CountDownLatch(1);

        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                //当有其他线程删除节点时，代表有其他线程释放锁，唤醒阻塞线程
                countDownLatch.countDown();
            }
        };
        //编写监听器
        zkClient.subscribeDataChanges(lockPath,iZkDataListener);

        //阻塞自己
        if (zkClient.exists(lockPath)){
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //取消注册
        zkClient.unsubscribeDataChanges(lockPath,iZkDataListener);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {//不会阻塞
        //创建节点
        try {
            zkClient.createEphemeral(lockPath);
        } catch (ZkNodeExistsException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    //释放锁
    @Override
    public void unlock() {
        zkClient.delete(lockPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
