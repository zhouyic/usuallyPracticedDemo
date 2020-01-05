package com.zyc.demo.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author Hcl
 * @since 2020-01-03
 */
@Data
@TableName("tb_role")
public class TbRole extends Model<TbRole> {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 角色名
     */
    private String name;
    /**
     * 角色备注
     */
    private String remarks;
    /**
     * 是否默认  1为默认
     */
    private Boolean isDefault;
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
    /**
     * 删除模板
     */
    private Integer delFlag;
    /**
     * 0 默认个人角色1 默认超级管理员 2 默认管理员 3 默认普通管理员 4企业超级管理员 5 企业管理员 6 企业普通管理员
     */
    private Integer type;
    /**
     * 企业id
     */
    private String companyId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbRole{" +
                ", id=" + id +
                ", name=" + name +
                ", remarks=" + remarks +
                ", isDefault=" + isDefault +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                ", type=" + type +
                ", companyId=" + companyId +
                "}";
    }
}