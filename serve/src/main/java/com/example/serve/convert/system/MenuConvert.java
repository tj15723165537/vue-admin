package com.example.serve.convert.system;

import com.example.serve.dto.system.MenuDTO;
import com.example.serve.entity.system.Menu;
import com.example.serve.vo.system.MenuVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuConvert {

    MenuVO entity2Vo(Menu entity);

    List<MenuVO> entityList2VoList(List<Menu> entityList);

    Menu dto2Entity(MenuDTO dto);

}
