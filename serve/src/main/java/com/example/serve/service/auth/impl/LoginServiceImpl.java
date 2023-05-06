package com.example.serve.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.convert.system.UserConvert;
import com.example.serve.dto.auth.LoginDTO;
import com.example.serve.entity.system.User;
import com.example.serve.exception.BusinessException;
import com.example.serve.mapper.auth.LoginMapper;
import com.example.serve.service.auth.LoginService;
import com.example.serve.utils.JwtUtil;
import com.example.serve.vo.auth.LoginVO;
import com.example.serve.vo.system.UserVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {

    @Autowired
    private UserConvert userConvert;

    @Override
    public LoginVO login(LoginDTO dto) {

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAccount, dto.getAccount());
        User user = getBaseMapper().selectOne(lambdaQueryWrapper);

        if (user == null) {
            throw new BusinessException("账号不存在");
        }

        // 比较明文密码和加密后的密码是否匹配
        if (!BCrypt.checkpw(dto.getPassword(), user.getPassword())) {
            throw new BusinessException("账号或密码错误");
        }

        if (user.getStatus().equals(0)) {
            throw new BusinessException("账号已被禁用");
        }

        UserVO userVO = userConvert.entity2Vo(user);
        String token = JwtUtil.sign(String.valueOf(user.getId()), user.getAccount(), user.getPassword());

        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        loginVO.setUserInfo(userVO);

        return loginVO;
    }
}
