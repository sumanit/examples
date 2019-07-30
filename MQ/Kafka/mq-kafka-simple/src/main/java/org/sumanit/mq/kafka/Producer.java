package org.sumanit.mq.kafka;

import org.apache.kafka.clients.admin.RecordsToDelete;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Producer {
    public static void main(String[] args) {
       // syncSend();
        asyncSend();
    }

    public static void syncSend(){
        Map<String,String> configMap = new HashMap<>();
        configMap.put("bootstrap.servers","127.0.0.1:9092");
        KafkaProducer kafkaProducer = new KafkaProducer(configMap, new StringSerializer(),new StringSerializer());
        ProducerRecord producerRecord = new ProducerRecord("sumanKafka","hello","helloWorld");
        RecordMetadata recordMetadata = null;
        try {
            recordMetadata = (RecordMetadata) kafkaProducer.send(producerRecord).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(recordMetadata.offset());

    }
    public static void asyncSend() {
        Map<String,String> configMap = new HashMap<>();
        configMap.put("bootstrap.servers","127.0.0.1:9092");
        KafkaProducer kafkaProducer = new KafkaProducer(configMap, new StringSerializer(),new StringSerializer());
        ProducerRecord producerRecord = new ProducerRecord("sumanKafka","hello","helloWorld");
        kafkaProducer.send(producerRecord, (recordMetadata, exception) -> {
            if(exception == null) {
                System.out.println(recordMetadata.offset());
                System.out.println(exception);
            }else{

            }
        });
    }
}
