package com.example.serve.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.dto.system.UserDTO;
import com.example.serve.dto.system.UserSearchDTO;
import com.example.serve.entity.system.User;
import com.example.serve.utils.PageList;
import com.example.serve.vo.system.UserVO;

public interface UserService extends IService<User> {
    PageList<UserVO> getPage(UserSearchDTO dto);

    void add(UserDTO dto);

    UserVO getById(Long id);

    void update(UserDTO dto);

    void delete(Long id);

    void updateStatus(Long id);
}
