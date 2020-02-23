package com.zyc.demo.swagger.controller;

import com.zyc.demo.swagger.anotation.RequiresPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/1/11 8:49
 */
@Api("swagger demo 测试")
@RestController
public class DemoController {
    @ApiOperation(value = "管理员登录" ,notes = "参数")
    @GetMapping("/test")
    @RequiresPermissions(needLogin = false)
    public String test(){
        return "hello world";
    }
}
