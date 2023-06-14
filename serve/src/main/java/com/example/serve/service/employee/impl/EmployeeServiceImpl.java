package com.example.serve.service.employee.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.convert.employee.EmployeeConvert;
import com.example.serve.dto.employee.EmployeeForm;
import com.example.serve.dto.employee.EmployeeSearchDTO;
import com.example.serve.entity.employee.Employee;
import com.example.serve.mapper.employee.EmployeeMapper;
import com.example.serve.service.employee.EmployeeService;
import com.example.serve.vo.employee.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeConvert employeeConvert;

    public IPage<Employee> getList(EmployeeSearchDTO params) {
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        if (params.getName() != null) {
            queryWrapper.like(Employee::getName, params.getName());
        }
        if (params.getPhone() != null) {
            queryWrapper.like(Employee::getPhone, params.getPhone());
        }
        if (params.getAddress() != null) {
            queryWrapper.like(Employee::getAddress, params.getAddress());
        }
        IPage<Employee> ipage = employeeMapper.selectPage(new Page<>(params.getPage(), params.getSize()), queryWrapper);
        return ipage;
    }

    //添加员工
    public Boolean add(EmployeeForm dto) {
        Employee employee = employeeConvert.dto2Entity(dto);
        Boolean result = this.save(employee);
        return result;
    }

    // 删除员工
    public Boolean remove(Long id) {
        boolean result = this.removeById(id);
        return result;
    }

    // 根据id查询员工
    public EmployeeVO getById(Long id) {
        Employee employee = getBaseMapper().selectById(id);
        EmployeeVO employeeVO = employeeConvert.entity2Vo(employee);
        return employeeVO;
    }

    // 修改员工
    public Boolean update(EmployeeForm dto) {
        Employee employee = employeeConvert.dto2Entity(dto);
        Boolean result = this.updateById(employee);
        return result;
    }

}
