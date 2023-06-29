package com.example.serve.dto.employee.employee;

import com.example.serve.utils.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmployeePageParamsDTO extends PageQuery {
    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;
}
