package com.example.serve.service.employee;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.dto.employee.EmployeeForm;
import com.example.serve.dto.employee.EmployeeSearchDTO;
import com.example.serve.entity.employee.Employee;
import com.example.serve.vo.employee.EmployeeVO;

public interface EmployeeService extends IService<Employee>{
    IPage<Employee> getList(EmployeeSearchDTO params);

    Boolean add(EmployeeForm employee);

    Boolean remove(Long id);

    EmployeeVO getById(Long id);

    Boolean update(EmployeeForm EmployeeForm);

}
