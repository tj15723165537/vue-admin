package com.example.serve.convert.system;

import com.example.serve.entity.system.Role;
import com.example.serve.vo.system.RoleVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleConvert {

    List<RoleVO> entityList2VoList(List<Role> entityList);
}
