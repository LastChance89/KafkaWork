package main.java.kafka.work.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import main.java.kafka.model.Message;
import main.java.kafka.work.service.ConsumerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitResult;
import reactor.core.publisher.Sinks.Many;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	
	private Many<Message> sink;

	
	ConsumerServiceImpl(){
		sink = Sinks.many().multicast().directBestEffort();

	}

	//@KafkaListener(topics = "#{'${kafka.topic.one}'.split(',')}", concurrency="3", groupId="Group1")
	public void receive(@Payload String message) {
		System.out.println( message +" " +  Thread.currentThread().getName());
		 sink.emitNext(new Message(Thread.currentThread().getName(), message),
	                (signalType, emitResult) -> emitResult == EmitResult.FAIL_NON_SERIALIZED);
	}

}