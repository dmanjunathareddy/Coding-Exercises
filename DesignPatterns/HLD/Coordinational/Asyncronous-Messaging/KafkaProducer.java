package com.softgroup.hld.coordination.designpatterns.asynchmessag;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducer {

	public void sendMessage(String message) {
        // Set up producer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create Kafka producer
        Producer<String, String> producer = new KafkaProducer<>(properties);

        // Create a Kafka record with a topic ("example.topic"), key, and value
        ProducerRecord<String, String> record = new ProducerRecord<>("example.topic", "key1", message);

        // Send the record asynchronously
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null) {
                    System.out.println("Message sent successfully! Topic: " + metadata.topic() +
                            ", Partition: " + metadata.partition() +
                            ", Offset: " + metadata.offset());
                } else {
                    exception.printStackTrace();
                }
            }
        });

        // Flush and close the producer
        producer.flush();
        producer.close();
	}
}
