package com.zyc.demo.mapper;
import com.zyc.demo.entity.model.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户实体 Mapper 接口
 * </p>
 * @author Hcl
 * @since 2020-01-03
 */
public interface TbUserMapper extends BaseMapper<TbUser> {
    List<TbUser> findUser(@Param("tbUser") TbUser tbUser);

    int updateUser(TbUser tbUser);
}