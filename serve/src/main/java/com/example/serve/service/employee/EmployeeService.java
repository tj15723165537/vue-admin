package com.example.serve.service.employee;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.dto.employee.employee.EmployeeCreateDTO;
import com.example.serve.dto.employee.employee.EmployeePageParamsDTO;
import com.example.serve.dto.employee.employee.EmployeeUpdateDTO;
import com.example.serve.entity.employee.Employee;
import com.example.serve.vo.employee.EmployeeVO;

public interface EmployeeService extends IService<Employee>{
    IPage<Employee> getList(EmployeePageParamsDTO params);

    Boolean add(EmployeeCreateDTO employee);

    Boolean remove(Long id);

    EmployeeVO getById(Long id);

    Boolean update(EmployeeUpdateDTO EmployeeDTO);

}
