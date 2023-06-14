package com.example.serve.entity.system;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("menu")
public class Menu implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String path;

    private String name;

    private String redirect;

    private String title;

    private String icon;

    private Long pid;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
