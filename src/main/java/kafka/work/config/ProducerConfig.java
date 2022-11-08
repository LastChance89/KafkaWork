package main.java.kafka.work.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

//@Configuration
public class ProducerConfig {
	
	@Autowired 
	private ProducerFactory <String,String> producerFactory;
	

	//@TODO: Add in secure connection. 
	public Map<String,Object> setupProducerConfig(){
		Map<String,Object> pconfig = new HashMap<String,Object>(producerFactory.getConfigurationProperties());

		return pconfig;
	}
	
	@Bean
	public KafkaTemplate <String,String> template(){
		return new KafkaTemplate<String,String>(new DefaultKafkaProducerFactory<String,String>(setupProducerConfig()));
	}
	
	
}
