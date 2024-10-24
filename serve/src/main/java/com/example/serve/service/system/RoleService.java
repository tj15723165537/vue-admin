package com.example.serve.service.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.serve.dto.system.role.RoleAssignDTO;
import com.example.serve.dto.system.role.RoleCreateDTO;
import com.example.serve.dto.system.role.RolePageParamsDTO;
import com.example.serve.dto.system.role.RoleUpdateDTO;
import com.example.serve.entity.system.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.vo.system.RoleMenuListVO;
import com.example.serve.vo.system.RoleVO;

import java.util.List;

/**
* @author Administrator
* @description 针对表【role(角色管理)】的数据库操作Service
* @createDate 2023-07-04 16:01:09
*/
public interface RoleService extends IService<Role> {

    void add(RoleCreateDTO dto);

    IPage<Role> getList(RolePageParamsDTO dto);

    void delete(Long id);

    RoleVO getDetail(Long id);

    void update(RoleUpdateDTO dto);

    void assign(RoleAssignDTO dto);

    RoleMenuListVO getRoleMenuList(Long id);

    List<RoleVO> getAllList();

    Boolean isAdmin(Long id);
}
