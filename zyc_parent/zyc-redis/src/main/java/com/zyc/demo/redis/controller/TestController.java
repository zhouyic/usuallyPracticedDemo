package com.zyc.demo.redis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/12 22:00
 */
@RestController
public class TestController {
    @Value("${test}")
    private String test;
    @GetMapping("/test")
    public String test(){
        return test;
    }
}
