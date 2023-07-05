package com.example.serve.dto.system.role;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 角色添加
 */
@Data
public class RoleUpdateDTO {
    /**
     * id
     */
    @NotBlank(message =  "id不能为空")
    private String id;

    /**
     * 备注
     */
    private String remark;

}
