package com.example.serve.mapper.employee;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.serve.entity.employee.Employee;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> getList();
}
