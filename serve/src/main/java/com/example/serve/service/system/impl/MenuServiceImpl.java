package com.example.serve.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.entity.system.Menu;
import com.example.serve.mapper.system.MenuMapper;
import com.example.serve.service.system.MenuService;
import com.example.serve.vo.system.MenuVO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuVO> implements MenuService {


    public List<MenuVO> getList() {
        List<MenuVO> menuVOS = listWithTree();
        return menuVOS;
    }

    public List<MenuVO> listWithTree() {
        List<MenuVO> menuList = getBaseMapper().selectList(null);
        List<MenuVO> levelOneMenus = menuList.stream()
                .filter(item ->  item.getPid() == 0)
                .map(item -> {
                    item.setChildren(this.getChildrens(item, menuList));
                    return item;
                })
                .collect(Collectors.toList());
        return levelOneMenus;
    }

    private List<MenuVO> getChildrens(MenuVO root, List<MenuVO> all){
        List<MenuVO> treeMenus = all.stream()
                .filter(item ->  Objects.equals(item.getPid(), root.getId()))
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
