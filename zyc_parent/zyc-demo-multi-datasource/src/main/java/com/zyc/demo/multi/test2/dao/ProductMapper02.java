package com.zyc.demo.multi.test2.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/4/14 9:21
 */
public interface ProductMapper02 {
    Integer insert(@Param("name") String name, @Param("age") Integer age);

}
