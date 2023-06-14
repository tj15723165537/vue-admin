package com.example.serve.convert.employee;

import com.example.serve.dto.employee.EmployeeForm;
import com.example.serve.entity.employee.Employee;
import com.example.serve.vo.employee.EmployeeVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeConvert {

    Employee dto2Entity(EmployeeForm dto);

    EmployeeVO entity2Vo(Employee employee);

    List<EmployeeVO> entitylist2Volist(List<Employee> lists);
}
