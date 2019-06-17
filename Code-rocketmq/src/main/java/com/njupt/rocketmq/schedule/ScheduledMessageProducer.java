package com.njupt.rocketmq.schedule;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author wall
 * @date 2019/6/17  17:37
 * @description 延时消息的生成者
 */
public class ScheduledMessageProducer {
    public static void main(String[] args) throws Exception {

        //使用默认生产者，生产者组为：wall_Group
        DefaultMQProducer producer =
                new DefaultMQProducer("wall_Group");
        //指定地址，端口号
        producer.setNamesrvAddr("localhost:9876");
        //生产者实例名称
        producer.setInstanceName("rmq-instance");
        //开始生产
        producer.start();

        int totalMessagesToSend = 10;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("Scheduled_Topic",
                    ("每隔10s发送一条消息" + i).getBytes());
            //延时的级别为3 对应的时间为10s 就是发送后延时10S在把消息投递出去
            message.setDelayTimeLevel(5);
            producer.send(message);
        }
        producer.shutdown();
    }
}
