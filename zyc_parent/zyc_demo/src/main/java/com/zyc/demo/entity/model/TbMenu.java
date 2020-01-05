package com.zyc.demo.entity.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("tb_menu")
public class TbMenu extends Model<TbMenu> {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 为0 时为顶级目录其他为父级目录id
     */
    private Long parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 页面地址
     */
    private String url;
    /**
     * 权限
     */
    private String permission;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * icon样式
     */
    private String icon;
    /**
     * 是否显示：1 显示、0 隐藏
     */
    private Integer isShow;
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbMenu{" +
                ", id=" + id +
                ", parentId=" + parentId +
                ", name=" + name +
                ", url=" + url +
                ", permission=" + permission +
                ", sort=" + sort +
                ", icon=" + icon +
                ", isShow=" + isShow +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                "}";
    }
}