package com.zyc.demo;

import com.zyc.demo.multi.datasource.DBConfig1;
import com.zyc.demo.multi.datasource.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages = {"com.zyc.demo.multi.test1.dao","com.zyc.demo.multi.test2.dao"})
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
public class ZycDemoMultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZycDemoMultiDatasourceApplication.class, args);
	}

}
