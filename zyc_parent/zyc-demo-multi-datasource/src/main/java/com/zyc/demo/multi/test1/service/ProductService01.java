package com.zyc.demo.multi.test1.service;

import com.zyc.demo.multi.test1.dao.ProductMapper01;
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
public class ProductService01 {
    @Autowired
    ProductMapper01 productMapper01;
    @Autowired
    ProductMapper02 productMapper02;
    @Transactional
    public Integer insert(String name,Integer age){
        productMapper01.insertaa(name, age);
        productMapper02.insert(name, age);
        int i = 1 / 0;
        return 1;

    }
}
