package com.example.serve.dto.system.role;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 角色添加
 */
@Data
public class RoleUpdateDTO {
    /**
     * id
     */
    @NotNull(message =  "id不能为空")
    private Long id;
    /**
     * 备注
     */
    private String remark;

}
