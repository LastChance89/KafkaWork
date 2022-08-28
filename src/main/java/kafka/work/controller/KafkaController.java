package main.java.kafka.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.kafka.work.service.ProducerService;

@RestController
@RequestMapping("/kafka/request")
public class KafkaController {

	
	@Autowired 
	private ProducerService producerService;
	
	
	@PostMapping("/process")
	public String response() {
		producerService.send("Test");
		return "";
	}
	
}
