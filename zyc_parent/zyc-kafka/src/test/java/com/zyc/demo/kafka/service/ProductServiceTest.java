package com.zyc.demo.kafka.service;

import com.zyc.demo.kafka.constant.BaseResponse;
import com.zyc.demo.kafka.entity.Product;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2018/9/11 21:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class ProductServiceTest {
    @Autowired
    ProductService productService;
    @Test
    public void getAllTest(){
        BaseResponse res = productService.queryAll("宝");
        System.out.println(res);
    }
    @Test
    public void saveTest(){
        Product product = new Product();
        product.setId(3);
        product.setName("兰博基尼");
        product.setCtime(System.currentTimeMillis());
        Map<String, Object> save = productService.save(product);
        System.out.println(save);
    }
    @Test
    public void removeTest(){
        Map<String, Object> map = productService.remove(3);
        System.out.println(map);
    }
}
