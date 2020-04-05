package com.zyc.basicserver.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/2 22:42
 */
@Controller
public class BizpageContoller {
    //登录
//    @PostMapping("/login")
//    public String login(String username,String password){
//        return "index";
//    }
    //登录成功之后的首页
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //日志管理
    @GetMapping("/syslog")
    public String showOrder(){
        return "syslog";
    }
    //用户管理
    @GetMapping("/sysuser")
    public String addOrder(){
        return "sysuser";
    }
    //业务1
    @GetMapping("/biz1")
    public String biz1(){
        return "biz1";
    }
    //业务2
    @GetMapping("/biz2")
    public String biz2(){
        return "biz2";
    }
}
