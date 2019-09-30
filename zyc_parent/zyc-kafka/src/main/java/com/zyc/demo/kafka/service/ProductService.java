package com.zyc.demo.kafka.service;


import com.zyc.demo.kafka.constant.BaseResponse;
import com.zyc.demo.kafka.entity.Product;

import java.util.Map;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2018/9/11 20:39
 */
public interface ProductService {
    BaseResponse queryAll(String name);
    Map<String,Object> save(Product product);

    Map<String, Object> remove(Integer id);
}
