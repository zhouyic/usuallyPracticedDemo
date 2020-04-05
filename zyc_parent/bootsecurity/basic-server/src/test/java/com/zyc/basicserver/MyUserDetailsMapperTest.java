package com.zyc.basicserver;

import com.zyc.basicserver.mapper.MyUserDetailsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/5 9:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserDetailsMapperTest {
    @Autowired
    private MyUserDetailsMapper myUserDetailsMapper;
    @Test
    public void selectCountTest(){
        Integer integer = myUserDetailsMapper.selectCount();
        System.out.println(integer);
    }
}
