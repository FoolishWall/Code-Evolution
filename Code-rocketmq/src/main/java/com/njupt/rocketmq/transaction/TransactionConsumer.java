package com.njupt.rocketmq.transaction;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author wall
 * @date 2019/3/28  16:46
 * @description
 */
public class TransactionConsumer {

    public static void main(String[] args) throws MQClientException {
        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("transaction_consumer_group");
        // Specify name server addresses.
        consumer.setNamesrvAddr("localhost:9876");
        // Subscribe one more more topics to consume.
        //接受指定topic的消息
        consumer.subscribe("transaction_topic", "*");
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
        //Launch the consumer instance.创建消费者实例
        consumer.start();
    }
}
