package com.zyc.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    TestMappper testMappper;
    @Test
    public void testSelect(){
        List<Map<String, Object>> maps = testMappper.selectVeh();
        System.out.println(maps);
    }
}
