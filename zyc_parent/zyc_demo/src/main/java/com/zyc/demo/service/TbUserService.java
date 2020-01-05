package com.zyc.demo.service;
import com.zyc.demo.entity.model.TbRole;
import com.zyc.demo.entity.model.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户实体 服务类
 * </p>
 *
 * @author Hcl
 * @since 2020-01-03
 */
public interface TbUserService extends IService<TbUser>  {

    List<TbUser> findUser(TbUser tbUser);

}