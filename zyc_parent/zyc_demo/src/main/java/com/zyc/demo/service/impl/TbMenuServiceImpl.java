package com.zyc.demo.service.impl;
import com.zyc.demo.entity.model.TbMenu;
import com.zyc.demo.mapper.TbMenuMapper;
import com.zyc.demo.service.TbMenuService;
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
public class TbMenuServiceImpl extends ServiceImpl<TbMenuMapper, TbMenu> implements TbMenuService {
    @Autowired
    private TbMenuMapper tbMenuMapper;
}