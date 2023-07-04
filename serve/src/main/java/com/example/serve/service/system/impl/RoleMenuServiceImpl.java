package com.example.serve.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.entity.system.RoleMenu;
import com.example.serve.service.system.RoleMenuService;
import com.example.serve.mapper.system.RoleMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【role_menu(角色菜单关联表)】的数据库操作Service实现
* @createDate 2023-07-04 16:01:09
*/
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>
    implements RoleMenuService{

}




