package com.zyc.demo.mapper;

import com.zyc.demo.entity.model.TbUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/1/5 9:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TbUserMapperTest {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Test
    public void updateUser() {
        TbUser tbUser = new TbUser();
        tbUser.setName("test1");
        tbUser.setUid("3634080673050542270");
        int i = tbUserMapper.updateUser(tbUser);
        Assert.assertTrue(i>0);
    }
}