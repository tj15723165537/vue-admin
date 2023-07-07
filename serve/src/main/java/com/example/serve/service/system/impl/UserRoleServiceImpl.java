package com.example.serve.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.entity.system.UserRole;
import com.example.serve.service.system.UserRoleService;
import com.example.serve.mapper.system.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【user_role(用户角色关联表)】的数据库操作Service实现
 * @createDate 2023-07-04 16:01:09
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}




