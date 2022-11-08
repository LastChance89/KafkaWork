package main.java.kafka.reactive.consumer.service;

import reactor.kafka.receiver.KafkaReceiver;

public interface ReactiveConsumerService {
	public KafkaReceiver<Object, Object> getKafkaReceiver();
}
