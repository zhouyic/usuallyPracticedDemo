package com.zyc.demo.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zyc.demo.mybatis.plus.mapper")
public class ZycMybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZycMybatisPlusApplication.class, args);
	}

}
