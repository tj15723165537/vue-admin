package com.example.serve.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.entity.system.Menu;
import com.example.serve.vo.system.MenuVO;

import java.util.List;

public interface MenuService extends IService<MenuVO> {

    List<MenuVO> getList();

}
