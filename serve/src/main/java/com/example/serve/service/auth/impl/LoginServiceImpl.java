package com.example.serve.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.convert.system.UserConvert;
import com.example.serve.dto.auth.LoginDTO;
import com.example.serve.entity.system.RoleMenu;
import com.example.serve.entity.system.User;
import com.example.serve.exception.BusinessException;
import com.example.serve.mapper.auth.LoginMapper;
import com.example.serve.mapper.system.RoleMenuMapper;
import com.example.serve.service.auth.LoginService;
import com.example.serve.service.system.MenuService;
import com.example.serve.utils.JwtUtil;
import com.example.serve.vo.auth.LoginVO;
import com.example.serve.vo.system.MenuVO;
import com.example.serve.vo.system.UserVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {

    @Autowired
    private UserConvert userConvert;

    @Resource
    private MenuService menuService;

    @Resource
    private RoleMenuMapper roleMenuMapper;

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

    @Override
    public List<MenuVO> getAuthList() {
        List<MenuVO> list = menuService.getList();
        //TODO id写死的
        List<RoleMenu> roleMenuList = roleMenuMapper.selectList(new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, 1654309432060907526L));
        List<Long> menuList = roleMenuList.stream().map(item -> item.getMenuId()).collect(Collectors.toList());
        List<MenuVO> collect = list.stream().filter(item -> menuList.contains(item.getId())).collect(Collectors.toList());
        return collect;
    }
}
