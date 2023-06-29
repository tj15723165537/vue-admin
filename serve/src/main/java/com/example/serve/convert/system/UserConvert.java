package com.example.serve.convert.system;

import com.example.serve.dto.system.user.UserCreateDTO;
import com.example.serve.dto.system.user.UserUpdateDTO;
import com.example.serve.entity.system.User;
import com.example.serve.vo.system.UserVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserConvert {

    User createDto2Entity(UserCreateDTO dto);

    User updateDto2Entity(UserUpdateDTO dto);

    UserVO entity2Vo(User entity);

    List<UserVO> entityList2VoList(List<User> entityList);

}
