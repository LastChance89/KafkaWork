package main.java.kafka.work.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import main.java.kafka.work.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService {

	@Autowired 
	private KafkaTemplate<String,String> template;
	
	@Value("${kafka.topic.one}")
	private String topic;
	
	@Override
	public void send(String message) {
		System.out.println(message);
		template.send(topic,message);
	}
	
	
}
