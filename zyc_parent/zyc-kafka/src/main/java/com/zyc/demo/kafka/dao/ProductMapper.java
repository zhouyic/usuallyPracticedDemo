package com.zyc.demo.kafka.dao;


import com.zyc.demo.kafka.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @author zhouyicai
 * @date 2018/9/10 9:31
 */

public interface ProductMapper {
    List<Map<String,Object>> getAll(@Param(value="name") String name);

    Integer insert(Product product);

    Integer delete(Integer id);
}
