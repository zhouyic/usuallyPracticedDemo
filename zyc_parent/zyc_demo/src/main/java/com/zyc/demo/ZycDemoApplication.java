package com.zyc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**扫描包*/
@MapperScan({"com.zyc.demo.mapper"})
public class ZycDemoApplication {

	public static void main(String[] args) {
		//
		SpringApplication.run(ZycDemoApplication.class, args);
	}

}
