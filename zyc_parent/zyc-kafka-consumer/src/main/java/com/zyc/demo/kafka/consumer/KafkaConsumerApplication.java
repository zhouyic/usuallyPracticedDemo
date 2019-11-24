package com.zyc.demo.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KafkaConsumerApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext app = SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
