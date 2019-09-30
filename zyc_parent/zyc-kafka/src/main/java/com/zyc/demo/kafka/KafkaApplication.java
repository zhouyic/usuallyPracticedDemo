package com.zyc.demo.kafka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan("com.zyc.demo.kafka.dao")
public class KafkaApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext app = SpringApplication.run(KafkaApplication.class, args);
	}

}
