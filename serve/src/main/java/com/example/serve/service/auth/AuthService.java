package com.example.serve.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serve.dto.auth.LoginDTO;
import com.example.serve.dto.auth.ResetPasswordDTO;
import com.example.serve.entity.system.User;
import com.example.serve.vo.auth.LoginVO;
import com.example.serve.vo.system.MenuVO;

import java.util.List;

public interface AuthService extends IService<User> {
    LoginVO login(LoginDTO dto);

    List<MenuVO> getAuthList(Long id);

    void resetPassword(ResetPasswordDTO dto, Long currentUserId);
}
