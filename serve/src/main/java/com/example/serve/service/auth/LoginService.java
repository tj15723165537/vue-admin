package com.example.serve.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.dto.auth.LoginDTO;
import com.example.serve.entity.system.User;
import com.example.serve.vo.auth.LoginVO;

public interface LoginService extends IService<User> {
    LoginVO login(LoginDTO dto);

}
