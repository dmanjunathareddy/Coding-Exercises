package com.softgroup.hld.coordination.designpatterns.asynchmessag;

public class AsyncMessagingExample {
	public static void main(String[] args) {
		KafkaProducer kafkaProducer = new KafkaProducer();
		kafkaProducer.sendMessage("Hello, Kafka!");
		KafkaConsumer consumer = new KafkaConsumer();
		consumer.consumeMessage();
	}
}
