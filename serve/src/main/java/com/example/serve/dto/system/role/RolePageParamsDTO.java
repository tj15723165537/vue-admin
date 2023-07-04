package com.example.serve.dto.system.role;

import com.example.serve.utils.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RolePageParamsDTO extends PageQuery {

    @ApiModelProperty(value = "角色名")
    private String name;

}
