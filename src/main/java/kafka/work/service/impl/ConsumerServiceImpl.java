package main.java.kafka.work.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import main.java.kafka.work.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@KafkaListener(topics = "#{'${kafka.topic.one}'.split(',')}", concurrency="3", groupId="Group1")
	public void receive(@Payload String message) {
		System.out.println( message +" " +  Thread.currentThread().getName());
	}

}
