package com.zyc.demo.mybatis.plus.entity;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import org.apache.ibatis.jdbc.SQL;

/**
 * <p>
 * 
 * </p>
 *
 * @author Hcl
 * @since 2019-12-15
 */
@Data
@TableName("tb_user")
public class TbUser extends Model<TbUser> {
    private static final long serialVersionUID = 1L;
/**
 * 主键
 */
    @TableId(value="id", type= IdType.ID_WORKER)
    private Long id;
/**
 * 姓名
 */
    @TableField(condition = SqlCondition.LIKE)
    private String name;
/**
 * 年龄
 */
    private Integer age;
/**
 * 邮箱
 */
    private String email;
/**
 * 直属上级id
 */
    private Long managerId;
/**
 * 创建时间
 */
    private LocalDateTime createTime;
    /**
    *备注
    */
    @TableField(exist = false)
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

//    @Override
//    public String toString() {
//        return "TbUser{" +
//        ", id=" + id +
//        ", name=" + name +
//        ", age=" + age +
//        ", email=" + email +
//        ", managerId=" + managerId +
//        ", createTime=" + createTime +
//        "}";
//    }
}