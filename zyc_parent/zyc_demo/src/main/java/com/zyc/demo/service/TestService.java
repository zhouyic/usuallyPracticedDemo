package com.zyc.demo.service;

import org.springframework.stereotype.Service;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/8 22:32
 */
@Service
public class TestService {

    public String test1(){
        System.out.println(1 / 0);
        return "test1";
    }
}
