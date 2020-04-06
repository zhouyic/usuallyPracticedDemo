package com.zyc.jwtserver.mapper;

import com.zyc.jwtserver.model.MyUserDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/5 9:41
 */
public interface MyUserDetailsMapper {
    Integer selectCount();
    MyUserDetails findByUserName(@Param("username") String username);

    List<String> findRoleByUserName(@Param("username") String username);

    List<String> findAuthorityByRoleName(@Param("roleNameList") List<String> roleNameList);
}
