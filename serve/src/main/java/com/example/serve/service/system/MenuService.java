package com.example.serve.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.dto.system.MenuDTO;
import com.example.serve.entity.system.Menu;
import com.example.serve.vo.system.MenuVO;

import java.util.List;

public interface MenuService extends IService<Menu> {

    List<MenuVO> getList();


    void add(MenuDTO menuDTO);

    void delete(Long id);

    void update(MenuDTO menuDTO);

    MenuVO getDetail(Long id);
}
