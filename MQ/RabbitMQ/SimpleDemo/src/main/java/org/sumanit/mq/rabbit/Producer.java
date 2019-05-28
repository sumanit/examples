package org.sumanit.mq.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by 苏曼 on 2019/5/27.
 */
public class Producer {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws InterruptedException {
        // 创建链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置连接参数
        factory.setHost("localhost");
        // 设置端口
        factory.setPort(5672);
        // 设置用户名
        factory.setUsername("guest");
        // 设置密码
        factory.setPassword("guest");
        try {
            // 获取连接
            Connection connection = factory.newConnection();
            // 创建一个通道
            Channel channel = connection.createChannel();
            // 定义一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 定义一个消息
            String message = "Hello World!";
            // 发布消息
            for (int i=0;i<10000;i++) {
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                Thread.sleep(1000);
            }
            System.out.println(" [x] Sent '" + message + "'");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
