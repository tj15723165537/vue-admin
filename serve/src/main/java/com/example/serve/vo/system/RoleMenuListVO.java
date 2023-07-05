package com.example.serve.vo.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 角色添加
 */
@Data
public class RoleMenuListVO {
    /**
     * 角色已有权限菜单列表
     */
    @ApiModelProperty(value = "角色已有权限菜单列表")
    private List<Long> roleMenuList;
    /**
     * 所有菜单列表
     */
    @ApiModelProperty(value = "所有菜单列表")
    private  List<MenuVO> menuList;
}
