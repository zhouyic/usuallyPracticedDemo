package com.zyc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="com.zyc.demo.dao")
public class ZycDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZycDemoApplication.class, args);
	}

}
