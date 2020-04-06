package com.zyc.jwtserver.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/5 9:41
 */
public interface MyRBACMapper {
    List<String> findUriByUserName(@Param("username") String username);
}
