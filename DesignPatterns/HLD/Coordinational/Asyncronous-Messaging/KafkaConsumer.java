package com.softgroup.hld.coordination.designpatterns.asynchmessag;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumer {
	
	public void consumeMessage() {
        // Set up consumer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "my-group");
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());

        // Create Kafka consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Subscribe to the Kafka topic
        consumer.subscribe(Collections.singletonList("example.topic"));

        // Poll for messages asynchronously
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Received message: " +
                        "Topic: " + record.topic() +
                        ", Partition: " + record.partition() +
                        ", Offset: " + record.offset() +
                        ", Key: " + record.key() +
                        ", Value: " + record.value());
            }
        }
	}
}
