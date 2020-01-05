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
@TableName("tr_user_role")
public class TrUserRole extends Model<TrUserRole> {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 中交用户id
     */
    private String uid;
    /**
     * 角色id
     */
    private Long roleId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TrUserRole{" +
                ", id=" + id +
                ", uid=" + uid +
                ", roleId=" + roleId +
                "}";
    }
}