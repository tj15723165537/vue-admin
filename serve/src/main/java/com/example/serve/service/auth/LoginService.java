package com.example.serve.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.dto.auth.LoginDTO;
import com.example.serve.entity.system.User;
import com.example.serve.vo.system.UserVO;

import java.util.Map;

public interface LoginService extends IService<User> {
    Map<String,Object> login(LoginDTO dto);

}
