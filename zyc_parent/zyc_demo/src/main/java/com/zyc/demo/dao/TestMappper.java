package com.zyc.demo.dao;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMappper {
        List<Map<String,Object>> selectVeh();
}
