package org.sumanit.mq.rocket;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Created by 苏曼 on 2019/5/30.
 */

public class Application {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new
                DefaultMQProducer("ddd");

        producer.setNamesrvAddr("127.0.0.1:9876");


        //启动实例.
        producer.start();


        for (int i = 0; i < 100; i++) {
            //创建一个消息实例, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" ,
                    ("Hello RocketMQ " +i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();
    }
}
