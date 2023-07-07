package com.example.serve.entity.system;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色管理
 * @TableName role
 */
@TableName(value ="role")
@Data
public class Role implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否是管理员 0 不是 1 是
     */
    private Integer isAdmin;
    /**
     * 创建时间
     */
    @TableField(fill =  FieldFill.INSERT)
    private Date createTime;
}