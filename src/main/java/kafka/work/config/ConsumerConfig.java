package main.java.kafka.work.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

//@EnableKafka
//@Configuration
public class ConsumerConfig {

	@Autowired
	private ConsumerFactory<Integer, String> consumerFactory;

	//@TODO: Add in secure connection. 
	public Map<String, Object> setupProducerConfig() {
		Map<String, Object> cconfig = new HashMap<String, Object>(consumerFactory.getConfigurationProperties());

		return cconfig;
	}

	//@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(setupProducerConfig()));
		return factory;
	}

}