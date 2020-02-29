package com.zyx.kafka.kafkatest;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class kafkaTest {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        Properties props = new Properties();
        //kafka 集群，broker-list
        props.put("bootstrap.servers", "47.105.215.254:9092");
        props.put("acks", "all");
        //重试次数
        props.put("retries", 1);
        //批次大小
        props.put("batch.size", 16384);
        //等待时间
        props.put("linger.ms", 1);
        //RecordAccumulator 缓冲区大小
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new
                KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>("one",
                    Integer.toString(i), Integer.toString(i)));
        }
        System.out.print("朱以雄路过");
        System.out.print("朱以雄1再次路过3");
        System.out.println("奚好雷改动");
        producer.close();
    }
}
