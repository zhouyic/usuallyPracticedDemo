package com.zyc.demo.controller;

import com.zyc.demo.entity.ResponseResult;
import com.zyc.demo.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/8 22:17
 */
@RestController
public class TestController {
    @Resource
    TestService testService;
    @GetMapping(value = "ex/system")
    public ResponseResult test1(){
        Object o = null;
        o.toString();
//        testService.test1();
        return new ResponseResult();
    }
}
