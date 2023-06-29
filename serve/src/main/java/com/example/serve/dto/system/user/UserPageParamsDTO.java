package com.example.serve.dto.system.user;

import com.example.serve.utils.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserPageParamsDTO extends PageQuery {

    @ApiModelProperty(value = "用户名")
    private String account;

    @ApiModelProperty(value = "状态")
    private String status;

}
