package com.example.serve.dto.system.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserUpdateDTO {

    @ApiModelProperty(value = "id",required = true)
    @NotNull(message = "id不能为空")
    private Long id;

    @ApiModelProperty(value = "账号",required = true)
    @NotBlank(message = "账号不能为空")
    private String account;

    @ApiModelProperty(value = "状态",required = true)
    @NotNull(message = "请选择状态")
    private Integer status;

    @ApiModelProperty(value = "角色",required = true)
    @NotNull(message = "请选择角色")
    private Long role;

}
