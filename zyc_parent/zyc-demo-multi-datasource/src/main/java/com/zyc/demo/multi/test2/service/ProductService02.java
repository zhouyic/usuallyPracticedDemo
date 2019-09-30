package com.zyc.demo.multi.test2.service;

import com.zyc.demo.multi.test2.dao.ProductMapper02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/4/14 9:22
 */
@Service
public class ProductService02 {

    @Autowired
    ProductMapper02 productMapper02;
    @Transactional
    public Integer insert(String name,Integer age){
        return productMapper02.insert(name, age);
    }
}
