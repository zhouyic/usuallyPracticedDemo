package com.zyc.basicserver.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/2 22:42
 */
@Controller
public class HelloContoller {
    @GetMapping("/hello")
    public String hello(){
        return "world";
    }
}
