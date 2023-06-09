package com.example.serve.dto.employee.employee;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;
@Data
public class EmployeeCreateDTO {

    @ApiModelProperty(value = "员工姓名",required = true)
    @NotBlank(message = "员工姓名不能为空")
    private String name;

    @ApiModelProperty(value = "电话",required = true)
    @NotBlank(message = "电话不能为空")
    private String phone;

    @ApiModelProperty(value = "地址",required = true)
    @NotBlank(message = "地址不能为空")
    private String address;

    @ApiModelProperty(value = "入职日期",required = true)
    @Past(message = "入职日期不能大于当前日期")
    private Date date;

}
