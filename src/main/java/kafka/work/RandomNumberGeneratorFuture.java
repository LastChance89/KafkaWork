package main.java.kafka.work;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import main.java.kafka.work.service.ProducerService;

@Service
public class RandomNumberGeneratorFuture {

	@Autowired
	private ProducerService producerService;

	@Async
	public CompletableFuture<String> kakfaProduce(String thread) throws Exception {

		for (int i = 0; i < 100; i++) {
			producerService.send(String.valueOf(Math.round(Math.random() * 300) + 1) + " " + thread);
		}
		return new CompletableFuture<String>();

	}

}
