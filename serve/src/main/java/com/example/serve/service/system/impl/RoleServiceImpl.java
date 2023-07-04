package com.example.serve.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.dto.system.role.RoleCreateDTO;
import com.example.serve.dto.system.role.RolePageParamsDTO;
import com.example.serve.entity.employee.Employee;
import com.example.serve.entity.system.Role;
import com.example.serve.service.system.RoleService;
import com.example.serve.mapper.system.RoleMapper;
import com.example.serve.vo.system.RoleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @description 针对表【role(角色管理)】的数据库操作Service实现
 * @createDate 2023-07-04 16:01:09
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public void add(RoleCreateDTO dto) {
        Role role = new Role();
        role.setName(dto.getName());
        role.setRemark(dto.getRemark());
        roleMapper.insert(role);
    }

    @Override
    public IPage<Role> getList(RolePageParamsDTO dto) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<Role>();
        if (dto.getName() != null) {
            queryWrapper.like(Role::getName, dto.getName());
        }
        Page<Role> page = new Page<>(dto.getPage(), dto.getSize());
        IPage iPage = roleMapper.selectPage(page, queryWrapper);
        return iPage;
    }
}




