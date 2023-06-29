package com.example.serve.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.dto.system.user.UserCreateDTO;
import com.example.serve.dto.system.user.UserPageParamsDTO;
import com.example.serve.dto.system.user.UserUpdateDTO;
import com.example.serve.entity.system.User;
import com.example.serve.utils.PageList;
import com.example.serve.vo.system.UserVO;

public interface UserService extends IService<User> {
    PageList<UserVO> getPage(UserPageParamsDTO dto);

    void add(UserCreateDTO dto);

    UserVO getById(Long id);

    void update(UserUpdateDTO dto);

    void delete(Long id);

    void updateStatus(Long id);
}
