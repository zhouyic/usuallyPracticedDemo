package com.zyc.demo.multi.test1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/4/14 9:21
 */
public interface ProductMapper01 {


    Integer insertaa(@Param("name") String name, @Param("age") Integer age);
}
