package org.sumanit.mq.rocket;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {
        //senSyncMessage();
        sendOrderMessage();
    }
    public static void senSyncMessage()throws Exception {
        // 使用组名来初始化一个生产者
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        // 指定Server Name 地址.
        producer.setNamesrvAddr("localhost:9876");
        // 启动实例
        producer.start();
        for (int i = 0; i < 100; i++) {
            // 创建消息实例，指定 topic, tag 和 消息内容
            byte[] msgBytes =  ("Hello RocketMQ " +i).getBytes(RemotingHelper.DEFAULT_CHARSET);
            Message msg = new Message("TopicTest","TagA" ,msgBytes);
            // 发送消息并获取发送结果
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //生产者实例不在使用时进行关闭
        producer.shutdown();
    }
    public static void sendAsyncMessage() throws Exception {
        // 使用组名实例化生产者。
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        // 指定NameServer 地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动实例
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            //创建消息实例，指定 topic, tag 和 消息内容.
            byte[] msgBytes =  ("Hello world " +i).getBytes(RemotingHelper.DEFAULT_CHARSET);
            Message msg = new Message("TopicTest","TagA","OrderID188",msgBytes);
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }

        // 生产者实例不在使用时进行关闭.
        // producer.shutdown();
    }
    public static void sendOneWayMessage() throws Exception{
        // 使用组名实例化生产者.
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        // 指定NameServer 地址.
        producer.setNamesrvAddr("localhost:9876");
        // 启动实例.
        producer.start();
        for (int i = 0; i < 100; i++) {
            // 创建消息实例，指定 topic, tag 和 消息内容.
            byte[] msgBytes =  ("Hello world " +i).getBytes(RemotingHelper.DEFAULT_CHARSET);
            Message msg = new Message("TopicTest","TagA",msgBytes );
            // 发送消息.
            producer.sendOneway(msg);

        }
        // 生产者实例不在使用时进行关闭.
        producer.shutdown();

    }

    public static void sendOrderMessage() throws Exception{

        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 100; i++) {
            int orderId = i % 10;
            byte[] msgBytes =  ("Hello world " +i).getBytes(RemotingHelper.DEFAULT_CHARSET);
            Message msg = new Message("TopicTest", tags[i % tags.length], "KEY" + i,msgBytes);
            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, orderId);

            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();

    }

    public static void consumeMessage() throws MQClientException {
        // 用组名实例化消费者.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");

        // 指定NameServer 地址.
        consumer.setNamesrvAddr("localhost:9876");

        // 订阅一个Topic.
        consumer.subscribe("TopicTest", "*");
        // 注册回掉函数，从Broker中取到消息时会调用.
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动消费者实例.
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
