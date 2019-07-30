package org.sumanit.mq.rocket;

import org.apache.rocketmq.client.consumer.*;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

public class ddd {
    public static void main(String[] args) throws Exception {
        //消费组
        final MQPullConsumerScheduleService scheduleService = new MQPullConsumerScheduleService("GroupName1");
        //MQ NameService地址
        scheduleService.getDefaultMQPullConsumer().setNamesrvAddr("localhost:9876");
        //负载均衡模式
        scheduleService.setMessageModel(MessageModel.CLUSTERING);
        //需要处理的消息topic
        scheduleService.registerPullTaskCallback("TopicTest", new PullTaskCallback() {

            @Override
            public void doPullTask(MessageQueue mq, PullTaskContext context) {
                MQPullConsumer consumer = context.getPullConsumer();
                try {

                    long offset = consumer.fetchConsumeOffset(mq, false);
                    if (offset < 0)
                        offset = 0;
                    System.out.println(offset);
                    PullResult pullResult = consumer.pull(mq, "*", offset, 32);
                    System.out.printf("%s%n", offset + "\t" + mq + "\t" + pullResult);
                    switch (pullResult.getPullStatus()) {
                        case FOUND:
                            break;
                        case NO_MATCHED_MSG:
                            break;
                        case NO_NEW_MSG:
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                    consumer.updateConsumeOffset(mq, pullResult.getNextBeginOffset());


                    context.setPullNextDelayTimeMillis(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        scheduleService.start();
    }
}
