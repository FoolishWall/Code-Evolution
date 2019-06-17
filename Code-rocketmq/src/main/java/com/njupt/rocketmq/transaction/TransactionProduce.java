package com.njupt.rocketmq.transaction;


import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wall
 * @date 2019/3/28  14:56
 * @description 创建事务生成器
 */
public class TransactionProduce {
    public static void main(String[] args) throws MQClientException {
        //事务监听器
        TransactionListener transactionListener = new TransactionListenerImpl();
        //事务型消息队列
        TransactionMQProducer producer = new TransactionMQProducer("transaction_produce_group");
        //创建线程池处理检查请求
        ExecutorService executorService = new ThreadPoolExecutor(2, 5,
                100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000), r -> {
                    Thread thread = new Thread(r);
                    thread.setName("client-transaction-msg-check-thread");
                    return thread;
                });
        //指定地址，端口号
        producer.setNamesrvAddr("localhost:9876");
        producer.setExecutorService(executorService);
        producer.setTransactionListener(transactionListener);
        producer.start();
        for (int i = 0; i < 10; i++) {
            try {
                Message msg =
                        new Message("transaction_topic",
                                ("发送事务型消息" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.sendMessageInTransaction(msg, null);
                Thread.sleep(10);
            } catch (MQClientException | UnsupportedEncodingException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.shutdown();
    }
}
