package com.zyc.demo.kafka.entity;

import lombok.Data;

/**
 * @Description: TODO
 * @author zhouyicai
 * @date 2018/9/10 9:32
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private Long ctime;
}
