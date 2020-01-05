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
@TableName("tr_role_menu")
public class TrRoleMenu extends Model<TrRoleMenu> {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 菜单id
     */
    private Long menuId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TrRoleMenu{" +
                ", id=" + id +
                ", roleId=" + roleId +
                ", menuId=" + menuId +
                "}";
    }
}