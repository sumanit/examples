package org.sumanit.mq.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 苏曼 on 2019/5/29.
 */
@Component
public class SimpleProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
}
