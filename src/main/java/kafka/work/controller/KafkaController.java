package main.java.kafka.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.kafka.reactive.consumer.service.ReactiveConsumerService;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.ReceiverRecord;

@RestController
@RequestMapping("/kafka/request")
public class KafkaController {

	
	@Autowired 
	private ReactiveConsumerService reactiveConsumerService;
	
	
	@GetMapping(path = "/emit")
	Flux getEvent() {
		System.out.println("Doink");
		//return null;
		
		Flux<ReceiverRecord<Object, Object>> flux = reactiveConsumerService.getKafkaReceiver().receive();
		return flux.checkpoint("Starting").log().doOnNext(message -> message.receiverOffset().acknowledge())
				.map(ReceiverRecord::value).checkpoint("Done");
				
	}
	
	
	
	
}
