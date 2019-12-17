package org.sumanit.mq.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {
        Map<String,Object> configMap = new HashMap<>();
        KafkaConsumer kafkaConsumer = new KafkaConsumer(configMap, new StringDeserializer(),new StringDeserializer());
        kafkaConsumer.subscribe(Collections.singletonList("topic"));
        kafkaConsumer.poll(Duration.ofSeconds(100));
        kafkaConsumer.commitSync();

    }
}
