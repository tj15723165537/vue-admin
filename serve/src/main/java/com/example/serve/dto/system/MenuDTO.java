package com.example.serve.dto.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class MenuDTO implements Serializable {
    @ApiModelProperty(value = "菜单路径")
    @NotEmpty(message = "菜单路径不能为空")
    private String path;

    @ApiModelProperty(value = "路由名称")
    @NotEmpty(message = "路由名称不能为空")
    private String name;

    @ApiModelProperty(value = "重定向路径")
    @NotEmpty(message = "重定向路径不能为空")
    private String redirect;

    @ApiModelProperty(value = "菜单标题")
    @NotEmpty(message = "菜单标题不能为空")
    private String title;

    @ApiModelProperty(value = "菜单图标")
    @NotEmpty(message = "请选择菜单图标")
    private String icon;

    @ApiModelProperty(value = "父级菜单")
    @NotNull(message = "请选择父级菜单")
    private Long pid;
}
