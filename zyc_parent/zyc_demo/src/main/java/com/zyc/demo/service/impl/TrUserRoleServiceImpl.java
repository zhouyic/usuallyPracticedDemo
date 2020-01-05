package com.zyc.demo.service.impl;
import com.zyc.demo.entity.model.TrUserRole;
import com.zyc.demo.mapper.TrUserRoleMapper;
import com.zyc.demo.service.TrUserRoleService;
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
 * @since 2020-01-03
 */
@Service
@Transactional
public class TrUserRoleServiceImpl extends ServiceImpl<TrUserRoleMapper, TrUserRole> implements TrUserRoleService {
    @Autowired
    private TrUserRoleMapper trUserRoleMapper;
}