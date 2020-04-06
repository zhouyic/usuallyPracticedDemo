package com.zyc.jwtserver.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/2 22:42
 */
@RestController
public class HelloContoller {
    @GetMapping("/hello")
    public String hello(){
        return "world";
    }
}
