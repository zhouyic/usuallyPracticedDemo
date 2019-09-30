package com.zyc.demo.multi.controller;

import com.zyc.demo.multi.test1.service.ProductService01;
import com.zyc.demo.multi.test2.service.ProductService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/4/14 9:37
 */
@RestController
public class MybatisMultiDataSourceController {
    @Autowired
    ProductService01 productService01;
    @Autowired
    ProductService02 productService02;
    @RequestMapping("insert1")
    public Integer insert1(String name,Integer age){
        return productService01.insert(name,age);
    }

    @RequestMapping("insert2")
    public Integer insert2(String name,Integer age){
        return productService02.insert(name,age);
    }
}
