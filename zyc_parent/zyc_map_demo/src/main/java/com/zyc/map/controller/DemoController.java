package com.zyc.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2021/3/1 20:38
 */
@Controller
public class DemoController {
    @GetMapping("gaoDeMapDemo1")
    public String gaoDeMapDemo1(){
        return "gaoDeMapDemo1";
    }

    @GetMapping("gaoDeMapDemo2")
    public String gaoDeMapDemo2(){
        return "gaoDeMapDemo2";
    }
    @GetMapping("gaoDeMapDemo3")
    public String gaoDeMapDemo3(){
        return "gaoDeMapDemo3";
    }

    @GetMapping("gaoDeMapDemo4")
    public String gaoDeMapDemo4(){
        return "gaoDeMapDemo4";
    }
}
