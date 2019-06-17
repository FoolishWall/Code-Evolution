package com.njupt.rocketmq.schedule;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author wall
 * @date 2019/6/17  17:37
 * @description 延时消息的消费者
 */
public class ScheduledMessageConsumer {
    public static void main(String[] args) throws Exception {
        //消费组为：wall_Consumer
        DefaultMQPushConsumer consumer =
                new DefaultMQPushConsumer("wall_Consumer");
        //指定地址，端口号
        consumer.setNamesrvAddr("localhost:9876");
        //消费者实例名称
        consumer.setInstanceName("rmq-instance");
        //指定Topic
        consumer.subscribe("Scheduled_Topic", "*");
        //编写监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messages,
                                                            ConsumeConcurrentlyContext context) {
                for (MessageExt message : messages) {
                    System.out.println("消费者接受到消息:"+new String(message.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}
