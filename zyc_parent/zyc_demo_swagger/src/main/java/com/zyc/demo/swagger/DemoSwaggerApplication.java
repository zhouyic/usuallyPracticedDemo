package com.zyc.demo.swagger;

import com.zyc.demo.swagger.config.WebMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebMvcConfig.class)
public class DemoSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSwaggerApplication.class, args);
    }

}
