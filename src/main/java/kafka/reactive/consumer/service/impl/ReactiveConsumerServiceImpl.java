package main.java.kafka.reactive.consumer.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.kafka.reactive.consumer.config.ReactiveConsumerConfiguration;
import main.java.kafka.reactive.consumer.service.ReactiveConsumerService;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.internals.ConsumerFactory;
import reactor.kafka.receiver.internals.DefaultKafkaReceiver;

@Service
public class ReactiveConsumerServiceImpl implements ReactiveConsumerService
{

	@Autowired
	private ReactiveConsumerConfiguration reactiveConsumerConfiguration;
	
	public KafkaReceiver<Object, Object> getKafkaReceiver() {
		return new DefaultKafkaReceiver<Object, Object>(ConsumerFactory.INSTANCE, 
				ReceiverOptions.create(reactiveConsumerConfiguration.getProperties()).subscription(Collections.singleton(String.valueOf(reactiveConsumerConfiguration.getProperties().get("kafka.topic.one"))))
				);
	}
	
}
