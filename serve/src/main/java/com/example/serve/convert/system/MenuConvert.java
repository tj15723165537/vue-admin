package com.example.serve.convert.system;

import com.example.serve.dto.system.menu.MenuCreateDTO;
import com.example.serve.dto.system.menu.MenuUpdateDTO;
import com.example.serve.entity.system.Menu;
import com.example.serve.vo.system.MenuVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuConvert {

    MenuVO entity2Vo(Menu entity);

    List<MenuVO> entityList2VoList(List<Menu> entityList);

    Menu createDto2Entity(MenuCreateDTO dto);

    Menu updateDto2Entity(MenuUpdateDTO dto);

}
