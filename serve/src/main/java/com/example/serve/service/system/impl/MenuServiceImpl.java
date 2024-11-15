package com.example.serve.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.convert.system.MenuConvert;
import com.example.serve.dto.system.menu.MenuCreateDTO;
import com.example.serve.dto.system.menu.MenuUpdateDTO;
import com.example.serve.entity.system.Menu;
import com.example.serve.exception.BusinessException;
import com.example.serve.mapper.system.MenuMapper;
import com.example.serve.mapper.system.RoleMapper;
import com.example.serve.service.system.MenuService;
import com.example.serve.vo.system.MenuVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Resource
    private MenuConvert menuConvert;
    @Resource
    private RoleMapper roleMapper;

    public List<MenuVO> getList() {
        List<MenuVO> menuVOS = listWithTree();
        return menuVOS;
    }

    @Override
    public void add(MenuCreateDTO menuDTO) {
        Menu parentMenu = getBaseMapper().selectById(menuDTO.getPid());
        if (Objects.isNull(parentMenu) && menuDTO.getPid() != 0) {
            throw new BusinessException("父级菜单不存在");
        }
        Menu entity = menuConvert.createDto2Entity(menuDTO);
        getBaseMapper().insert(entity);
//        roleMapper.
    }

    @Override
    public void delete(Long id) {
        Menu menu = getBaseMapper().selectById(id);
        if (Objects.isNull(menu)) {
            throw new BusinessException("菜单不存在");
        }
        List<Menu> menuList = getBaseMapper().selectList(null);
        menuList.forEach(item -> {
            if (Objects.equals(item.getPid(), id)) {
                throw new BusinessException("该菜单下存在子菜单，无法删除");
            }
        });
        getBaseMapper().deleteById(id);
    }

    @Override
    public void update(MenuUpdateDTO menuDTO) {
        Menu parentMenu = getBaseMapper().selectById(menuDTO.getPid());
        if (Objects.isNull(parentMenu) && menuDTO.getPid() != 0) {
            throw new BusinessException("父级菜单不存在");
        }
        Menu entity = menuConvert.updateDto2Entity(menuDTO);
        LambdaQueryWrapper<Menu> lambdaQueryWrapper = new LambdaQueryWrapper<Menu>();
        this.update(entity, lambdaQueryWrapper.eq(Menu::getId, menuDTO.getId()));
    }

    @Override
    public MenuVO getDetail(Long id) {
        if (Objects.isNull(id)) {
            throw new BusinessException("菜单id不能为空");
        }
        Menu menu = getBaseMapper().selectById(id);
        if (Objects.isNull(menu)) {
            throw new BusinessException("菜单不存在");
        }
        return menuConvert.entity2Vo(menu);
    }

    public List<MenuVO> listWithTree() {
        List<Menu> menuList = getBaseMapper().selectList(null);
        List<MenuVO> menuVOS = menuConvert.entityList2VoList(menuList);
        List<MenuVO> levelOneMenus = menuVOS.stream()
                .filter(item -> item.getPid() == 0)
                .map(item -> {
                    item.setChildren(this.getChildrens(item, menuVOS));
                    return item;
                })
                .collect(Collectors.toList());
        return levelOneMenus;
    }

    private List<MenuVO> getChildrens(MenuVO root, List<MenuVO> all) {
        List<MenuVO> treeMenus = all.stream()
                .filter(item -> Objects.equals(item.getPid(), root.getId()))
                .map(item -> {
                    //递归添加子菜单
                    List<MenuVO> childrens = getChildrens(item, all);
                    item.setChildren(childrens);
                    return item;
                })
                .collect(Collectors.toList());
        return treeMenus;
    }

}
