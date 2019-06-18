package com.njupt.concurrency.future;

import java.util.concurrent.*;

/**
 * @author wall
 * @date 2019/6/18  11:33
 * @description
 */
public class CancelTaskUsingFuture {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future futureTask = executorService.submit(()->{
            System.out.println(Thread.currentThread().getName());
            //模拟耗时操作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            System.out.println(Thread.currentThread().getName());
        });
        try {
            futureTask.get(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }finally {
            futureTask.cancel(true);
        }
    }
}
