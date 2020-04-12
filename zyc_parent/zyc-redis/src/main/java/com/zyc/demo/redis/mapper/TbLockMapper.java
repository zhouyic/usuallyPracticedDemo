package com.zyc.demo.redis.mapper;


import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * @author Hcl
 * @since 2020-01-03
 */
public interface TbLockMapper {

    int insertData(@Param("id") int id);
    int del(@Param("id") int id);

}