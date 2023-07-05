package com.example.serve.dto.system.role;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 角色添加
 */
@Data
public class RoleAssignDTO {

    /**
     * id
     */
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "角色id")
    private Long id;

    /**
     * 菜单集合
     */
    @ApiModelProperty(value = "菜单集合")
    private List<Long> menuList;

}
