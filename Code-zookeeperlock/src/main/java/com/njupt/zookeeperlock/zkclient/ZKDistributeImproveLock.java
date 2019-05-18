package com.njupt.zookeeperlock.zkclient;


import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author wall
 * @date 2019/5/18  10:12
 * @description 利用临时顺序节点，当一个线程释放锁时，唤醒下一个线程，而不是唤醒所有线程
 */
public class ZKDistributeImproveLock implements Lock {

    private String lockPath;
    private ZkClient zkClient;
    private String currentPath;
    private String beforePath;


    public ZKDistributeImproveLock(String lockPath) {
        this.lockPath = lockPath;
        this.zkClient = new ZkClient("localhost:2181");
        this.zkClient.setZkSerializer(new MyZkSerializer());
        //考虑存在并发创建节点
        if (!this.zkClient.exists(lockPath)){
            //根节点为持久节点
            this.zkClient.createPersistent(lockPath);
        }
    }

    @Override
    public void lock() {
        if (!tryLock()){
            waitForLock();
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
                countDownLatch.countDown();
            }
        };
        //监视前一个顺序节点
        this.zkClient.subscribeDataChanges(this.beforePath,iZkDataListener);

        if (this.zkClient.exists(this.beforePath)){
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //取消注册
        this.zkClient.unsubscribeDataChanges(this.beforePath,iZkDataListener);
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        if (this.currentPath == null){
            currentPath = this.zkClient.createEphemeralSequential(lockPath+"/","*");
        }

        //获取根节点的所有子节点
        List<String> children = this.zkClient.getChildren(lockPath);

        //将list集合排序
        children.sort(String::compareTo);

        //判断当前节点是否最小
        if (this.currentPath.equals(lockPath+"/"+children.get(0))){
            return true;
        }else {
            //获取前一个节点
            //首先获取当前路径的索引
            int curIndex  = children.indexOf(currentPath.substring(lockPath.length()+1));
            this.beforePath = lockPath+"/"+children.get(curIndex-1);
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        this.zkClient.delete(this.currentPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
