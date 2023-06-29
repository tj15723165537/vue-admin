package com.example.serve.dto.system.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class UserUpdateDTO {

    @ApiModelProperty(value = "id",required = true)
    @NotBlank(message = "id不能为空")
    private Long id;

    @ApiModelProperty(value = "账号",required = true)
    @NotBlank(message = "账号不能为空")
    private String account;

    @ApiModelProperty(value = "状态",required = true)
    @NotEmpty(message = "请选择状态")
    private Integer status;

}
