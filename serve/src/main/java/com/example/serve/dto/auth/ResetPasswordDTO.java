package com.example.serve.dto.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ResetPasswordDTO {

    @ApiModelProperty(value = "原密码",required = true)
    @NotBlank(message = "原密码不能为空")
    private String oldPassword;

    @ApiModelProperty(value = "新密码",required = true)
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

}
