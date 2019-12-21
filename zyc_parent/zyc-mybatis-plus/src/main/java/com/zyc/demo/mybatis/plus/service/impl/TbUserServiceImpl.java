package com.zyc.demo.mybatis.plus.service.impl;
import com.zyc.demo.mybatis.plus.entity.TbUser;
import com.zyc.demo.mybatis.plus.mapper.TbUserMapper;
import com.zyc.demo.mybatis.plus.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hcl
 * @since 2019-12-15
 */
@Service
@Transactional
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;
}