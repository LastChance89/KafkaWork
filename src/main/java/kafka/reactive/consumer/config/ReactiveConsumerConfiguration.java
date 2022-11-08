package main.java.kafka.reactive.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class ReactiveConsumerConfiguration {

	@Autowired
	private ConsumerFactory<Integer, String> consumerFactory;
	
	public Map<String, Object> getProperties(){
		return  new HashMap<String, Object>(consumerFactory.getConfigurationProperties());
	}
	
}
