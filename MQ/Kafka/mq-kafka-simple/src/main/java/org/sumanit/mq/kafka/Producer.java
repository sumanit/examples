package org.sumanit.mq.kafka;

import org.apache.kafka.clients.admin.RecordsToDelete;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class Producer {
    public static void main(String[] args) throws Exception {
       // syncSend();
        asyncSend();
    }

    public static void syncSend() throws Exception{
        Map<String,String> configMap = new HashMap<>();
        configMap.put("bootstrap.servers","127.0.0.1:9092");
        KafkaProducer kafkaProducer = new KafkaProducer(configMap, new StringSerializer(),new StringSerializer());
        ProducerRecord producerRecord = new ProducerRecord("sumanKafka","hello","helloWorld");
        RecordMetadata recordMetadata = (RecordMetadata) kafkaProducer.send(producerRecord).get();
        System.out.println(recordMetadata.offset());

    }
    public static void asyncSend() throws Exception{
        Map<String,String> configMap = new HashMap<>();
        configMap.put("bootstrap.servers","127.0.0.1:9092");
        KafkaProducer kafkaProducer = new KafkaProducer(configMap, new StringSerializer(),new StringSerializer());
        ProducerRecord producerRecord = new ProducerRecord("sumanKafka","hello","helloWorld");
        kafkaProducer.send(producerRecord, (recordMetadata, exception) -> {
            System.out.println(recordMetadata.offset());
            System.out.println(exception);
        }).get();
    }
}
