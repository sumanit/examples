package org.sumanit.mq.rabbit;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * Created by 苏曼 on 2019/5/27.
 */
public class Producer {
    private final static String QUEUE_NAME = "queue.priority";
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
            Map arguments = new HashMap<String,Object>();
            arguments.put("x-max-priority",10);

            channel.queueDeclare(QUEUE_NAME, false, false, false, arguments);
            // 定义一个消息
            String message = "Hello World!";
            // 发布消息
            channel.confirmSelect();
            for (int i=0;i<10000;i++) {
                AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
                builder.priority(new Random().nextInt(100));
                channel.basicPublish("", QUEUE_NAME, builder.build(), message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
                Thread.sleep(10);
                while(channel.waitForConfirms()){
                    System.out.println(" [x] Sent '" + message + "'");
                }
            }
            System.out.println(" [x] Sent '" + message + "'");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
