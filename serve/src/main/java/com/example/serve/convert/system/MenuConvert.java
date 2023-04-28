package com.example.serve.convert.system;

import com.example.serve.entity.system.Menu;
import com.example.serve.vo.system.MenuVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuConvert {

    MenuVO entity2Vo(Menu entity);

}
