package com.example.serve.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serve.convert.system.UserConvert;
import com.example.serve.dto.system.UserDTO;
import com.example.serve.dto.system.UserSearchDTO;
import com.example.serve.entity.system.User;
import com.example.serve.exception.BusinessException;
import com.example.serve.mapper.system.UserMapper;
import com.example.serve.service.system.UserService;
import com.example.serve.utils.PageList;
import com.example.serve.vo.system.UserVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvert userConvert;

    @Override
    public PageList<UserVO> getPage(UserSearchDTO dto) {
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
    public void add(UserDTO dto) {
        User user = userConvert.dto2Entity(dto);
        String password = "123456";
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, salt);
        user.setPassword(hashedPassword);
        userMapper.add(user);
    }

    @Override
    public UserVO getById(Long id) {
        User user = userMapper.getById(id);
        UserVO userVO = userConvert.entity2Vo(user);
        return userVO;
    }

    @Override
    public void update(UserDTO dto) {
        User user = userConvert.dto2Entity(dto);
        userMapper.update(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }

    @Override
    public void updateStatus(Long id) {
        Integer selectOneStatus = userMapper.selectOneStatus(id);
        Integer status = selectOneStatus == 1 ? 0 : 1;
        int n = userMapper.updateStatus(id, status);
        if(n == 0) {
            throw new BusinessException("更新失败");
        }
    }
}
