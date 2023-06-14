package com.example.serve.vo.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuVO implements Serializable {

    @ApiModelProperty(value = "菜单id")
    private Long id;

    @ApiModelProperty(value = "菜单路径")
    private String path;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "跳转路径")
    private String redirect;

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "父菜单id")
    private Long pid;

    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<MenuVO> children;

}
