package com.zyc.demo.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@MapperScan("com.zyc.demo.redis.mapper")
@SpringBootApplication
public class ZycRedispplication {

	public static void main(String[] args) {
		SpringApplication.run(ZycRedispplication.class, args);
	}
}
