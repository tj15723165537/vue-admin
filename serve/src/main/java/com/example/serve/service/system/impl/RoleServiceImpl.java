package com.example.serve.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.convert.system.RoleConvert;
import com.example.serve.dto.system.role.RoleAssignDTO;
import com.example.serve.dto.system.role.RoleCreateDTO;
import com.example.serve.dto.system.role.RolePageParamsDTO;
import com.example.serve.dto.system.role.RoleUpdateDTO;
import com.example.serve.entity.employee.Employee;
import com.example.serve.entity.system.Role;
import com.example.serve.enums.WhetherEnum;
import com.example.serve.exception.BusinessException;
import com.example.serve.mapper.system.RoleMenuMapper;
import com.example.serve.service.system.MenuService;
import com.example.serve.service.system.RoleService;
import com.example.serve.mapper.system.RoleMapper;
import com.example.serve.vo.system.MenuVO;
import com.example.serve.vo.system.RoleMenuListVO;
import com.example.serve.vo.system.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.serve.entity.system.RoleMenu;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【role(角色管理)】的数据库操作Service实现
 * @createDate 2023-07-04 16:01:09
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private RoleConvert roleConvert;

    @Autowired
    private MenuService menuService;

    @Override
    public void add(RoleCreateDTO dto) {
        Role role = new Role();
        role.setName(dto.getName());
        role.setRemark(dto.getRemark());
        role.setIsAdmin(WhetherEnum.NO.code());
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

    @Override
    public void delete(Long id) {
        if (null == id) {
            throw new BusinessException("id不能为空");
        }
        if(isAdmin(id)){
            throw new BusinessException("不能删除管理员角色");
        }
        roleMapper.deleteById(id);
        roleMenuMapper.delete(new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId,id));
    }

    @Override
    public RoleVO getDetail(Long id) {
        if (null == id) {
            throw new BusinessException("id不能为空");
        }
        Role role = roleMapper.selectById(id);
        return roleConvert.entity2Vo(role);
    }

    @Override
    public void update(RoleUpdateDTO dto) {
        if(isAdmin(dto.getId())){
            throw new BusinessException("不能修改管理员角色");
        }
        Role role = roleConvert.dto2Entity(dto);
        role.setIsAdmin(WhetherEnum.NO.code());
        roleMapper.updateById(role);
    }

    @Override
    public void assign(RoleAssignDTO dto) {
        Role role = roleMapper.selectById(dto.getId());
        if (Objects.isNull(role)) {
            throw new BusinessException("角色不存在");
        }
        if(isAdmin(dto.getId())){
            throw new BusinessException("不能修改管理员权限");
        }
        roleMenuMapper.delete(new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, dto.getId()));
        for (Long menuId : dto.getMenuList()) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(dto.getId());
            roleMenu.setMenuId(menuId);
            roleMenuMapper.insert(roleMenu);
        }
    }

    @Override
    public RoleMenuListVO getRoleMenuList(Long id) {
        Role role = roleMapper.selectById(id);
        if (Objects.isNull(role)) {
            throw new BusinessException("角色不存在");
        }
        List<RoleMenu> roleMenus = roleMenuMapper.selectList(new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, id));
        List<Long> collect = roleMenus.stream().map(i -> i.getMenuId()).collect(Collectors.toList());
        List<MenuVO> list = menuService.getList();
        RoleMenuListVO roleMenuListVO = new RoleMenuListVO();
        roleMenuListVO.setRoleMenuList(collect);
        roleMenuListVO.setMenuList(list);
        return roleMenuListVO;
    }

    @Override
    public List<RoleVO> getAllList() {
        List<Role> roleList = roleMapper.selectList(null);
        return roleConvert.entityList2VoList(roleList);
    }

    public Boolean isAdmin(Long id){
        Role role = roleMapper.selectById(id);
        return role.getIsAdmin().equals(WhetherEnum.YES.code());
    }
}




