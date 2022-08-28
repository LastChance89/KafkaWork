package main.java.kafka.work;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;




@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) 

public class MainApplication implements CommandLineRunner {


	@Autowired 
	private RandomNumberGeneratorFuture fc;

	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	
		CompletableFuture<String> test1 = fc.kakfaProduce("one");
		CompletableFuture<String> test2 = fc.kakfaProduce("two");
		CompletableFuture<String> test3 = fc.kakfaProduce("three");
		CompletableFuture.allOf(test1,test2,test3).join();
		
	
		
	}
	


}
