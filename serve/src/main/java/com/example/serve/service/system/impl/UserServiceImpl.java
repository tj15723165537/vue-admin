package com.example.serve.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.convert.system.UserConvert;
import com.example.serve.dto.system.user.UserCreateDTO;
import com.example.serve.dto.system.user.UserPageParamsDTO;
import com.example.serve.dto.system.user.UserUpdateDTO;
import com.example.serve.entity.system.Role;
import com.example.serve.entity.system.User;
import com.example.serve.entity.system.UserRole;
import com.example.serve.exception.BusinessException;
import com.example.serve.mapper.system.RoleMapper;
import com.example.serve.mapper.system.UserMapper;
import com.example.serve.mapper.system.UserRoleMapper;
import com.example.serve.service.system.UserService;
import com.example.serve.utils.PageList;
import com.example.serve.vo.system.UserVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvert userConvert;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public PageList<UserVO> getPage(UserPageParamsDTO dto) {
        dto.setPage((dto.getPage() - 1) * dto.getSize());
        List<User> userList = userMapper.getPage(dto);
        List<UserVO> userVOList = userConvert.entityList2VoList(userList);
        Integer total = userMapper.getTotal();
        PageList<UserVO> pageList = new PageList<UserVO>();
        pageList.setContent(userVOList);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void add(UserCreateDTO dto) {
        Long count = userMapper.selectCount(new LambdaQueryWrapper<User>().eq(User::getAccount, dto.getAccount()));
        if (count > 0) {
            throw new BusinessException("用户名已经存在");
        }
        User user = userConvert.createDto2Entity(dto);
        String password = "123456";
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, salt);
        user.setPassword(hashedPassword);
        userMapper.add(user);
        User one = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getAccount, dto.getAccount()));
        Long roleId = dto.getRole();
        UserRole userRole = new UserRole();
        userRole.setUserId(one.getId());
        userRole.setRoleId(roleId);
        userRoleMapper.insert(userRole);
    }

    @Override
    public UserVO getById(Long id) {
        User user = userMapper.getById(id);
        UserVO userVO = userConvert.entity2Vo(user);
        UserRole userRoles = userRoleMapper.selectOne(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, id));
        userVO.setRole(userRoles.getRoleId());
        return userVO;
    }

    @Override
    public void update(UserUpdateDTO dto) {
        User user = userConvert.updateDto2Entity(dto);
        User entity = userMapper.selectById(dto.getId());
        if (isAdmin(entity.getId()) && dto.getStatus() == 0) {
            throw new BusinessException("管理员账户无法禁用");
        }
        user.setPassword(entity.getPassword());
        userMapper.update(user);
        userRoleMapper.delete(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, dto.getId()));
        Long roleId = dto.getRole();
        UserRole userRole = new UserRole();
        userRole.setUserId(dto.getId());
        userRole.setRoleId(roleId);
        userRoleMapper.insert(userRole);
    }

    @Override
    public void delete(Long id) {
        if (isAdmin(id)) {
            throw new BusinessException("管理员账户无法删除");
        }
        userMapper.delete(id);
        userRoleMapper.delete(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, id));
    }

    @Override
    public void updateStatus(Long id) {
        if (isAdmin(id)) {
            throw new BusinessException("管理员账户无法禁用");
        }
        Integer selectOneStatus = userMapper.selectOneStatus(id);
        Integer status = selectOneStatus == 1 ? 0 : 1;
        int n = userMapper.updateStatus(id, status);
        if (n == 0) {
            throw new BusinessException("更新失败");
        }
    }

    public Boolean isAdmin(Long id) {
        List<UserRole> userRoles = userRoleMapper.selectList(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, id));
        Boolean flag = false;
        for (UserRole userRole : userRoles) {
            Role role = roleMapper.selectById(userRole.getRoleId());
            if (role != null && role.getIsAdmin() == 1) {
                flag = true;
            }
        }
        return flag;
    }
}
