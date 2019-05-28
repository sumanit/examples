package org.sumanit.mq.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by 苏曼 on 2019/5/27.
 */
public class ConsumerTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置ip
        factory.setHost("127.0.0.1");
        // 设置端口
        factory.setPort(AMQP.PROTOCOL.PORT);
        // 设置用户名
        factory.setUsername("guest");
        // 设置密码
        factory.setPassword("guest");

        // 新建一个长连接
        Connection connection = factory.newConnection();

        // 创建一个通道(一个轻量级的连接)
        Channel channel = connection.createChannel();

        // 声明一个队列
        String QUEUE_NAME = "hello";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Consumer Wating Receive Message");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [C] Received '" + message + "'");
            }
        };

        // 订阅消息
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
