package com.zyc.demo.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 * 用户实体
 * </p>
 *
 * @author Hcl
 * @since 2020-01-03
 */
@Data
@TableName("tb_user")
public class TbUser extends Model<TbUser> {
    private static final long serialVersionUID = 1L;
    /**
     * 中交用户唯一标识
     */
    private String uid;
    /**
     * 掩码姓名
     */
    private String name;
    /**
     * 掩码手机号
     */
    private String mobile;
    /**
     * 0 正常 1 禁用
     */
    private Integer status;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Long updateTime;


    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                ", uid=" + uid +
                ", name=" + name +
                ", mobile=" + mobile +
                ", status=" + status +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                "}";
    }
}