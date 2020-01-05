package com.zyc.demo.service;

import com.zyc.demo.ZycDemoApplication;
import com.zyc.demo.entity.model.TbUser;
import com.zyc.demo.util.KeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/1/3 23:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TbUserServiceImplTest {
    @Autowired
    private TbUserService tbUserService;

    /**
     * 数据测试
     * @Transactional  避免测试数据污染数据库
     */
    @Transactional
    @Test
    public void insertTest(){
        List<TbUser> list = new ArrayList<>();
        TbUser tbUser = new TbUser();
        tbUser.setUid(KeyGenerator.instance().generator().toString());
        tbUser.setName("zyc1");
        tbUser.setMobile("17710836073");
        tbUser.setCreateTime(System.currentTimeMillis());
        tbUser.setCreateBy("owner");
        list.add(tbUser);
        Assert.assertTrue(tbUserService.saveBatch(list));
    }

    /**
     * 根据条件查询用户信息测试
     * timeout = 100 超时测试
     */
    @Test(timeout = 100)
    public void findUserTest(){
        TbUser tbUser = new TbUser();
        tbUser.setName("zyc1");
        List<TbUser> user = tbUserService.findUser(tbUser);
        Assert.assertTrue( user !=null && user.size()>0);
    }
}
