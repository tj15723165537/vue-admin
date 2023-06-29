package com.example.serve.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.dto.system.menu.MenuCreateDTO;
import com.example.serve.dto.system.menu.MenuUpdateDTO;
import com.example.serve.entity.system.Menu;
import com.example.serve.vo.system.MenuVO;

import java.util.List;

public interface MenuService extends IService<Menu> {

    List<MenuVO> getList();


    void add(MenuCreateDTO menuDTO);

    void delete(Long id);

    void update(MenuUpdateDTO menuDTO);

    MenuVO getDetail(Long id);
}
