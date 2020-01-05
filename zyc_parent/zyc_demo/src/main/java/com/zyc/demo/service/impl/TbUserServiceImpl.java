package com.zyc.demo.service.impl;
import com.zyc.demo.entity.model.TbUser;
import com.zyc.demo.mapper.TbUserMapper;
import com.zyc.demo.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户实体 服务实现类
 * </p>
 *
 * @author Hcl
 * @since 2020-01-03
 */
@Service
@Transactional
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> findUser(TbUser tbUser) {
        return tbUserMapper.findUser(tbUser);
    }
}