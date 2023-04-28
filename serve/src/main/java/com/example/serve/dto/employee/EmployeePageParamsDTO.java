package com.example.serve.dto.employee;

import com.example.serve.utils.PageQuery;
import lombok.Data;

@Data
public class EmployeePageParamsDTO extends PageQuery {

    private String name;

    private String phone;

    private String address;
}
