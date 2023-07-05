package com.example.serve.convert.system;

import com.example.serve.dto.system.role.RoleUpdateDTO;
import com.example.serve.entity.system.Role;
import com.example.serve.vo.system.RoleVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleConvert {
    RoleVO entity2Vo(Role entity);
    Role dto2Entity(RoleUpdateDTO dto);
    List<RoleVO> entityList2VoList(List<Role> entityList);
}
