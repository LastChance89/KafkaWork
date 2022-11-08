package main.java.kafka.work;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) 
@ComponentScan({"main.java.kafka.*"})
public class MainApplication implements CommandLineRunner {


	@Autowired 
	private RandomNumberGeneratorFuture fc;

	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		execute();
	}
	
	@Scheduled(fixedRate = 5000)
	private void execute() {
		try {
			CompletableFuture<String> test1 = fc.kakfaProduce("one");
			CompletableFuture<String> test2 = fc.kakfaProduce("two");
			CompletableFuture<String> test3 = fc.kakfaProduce("three");
			CompletableFuture.allOf(test1,test2,test3).join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
