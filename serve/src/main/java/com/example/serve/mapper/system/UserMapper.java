package com.example.serve.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.serve.dto.system.UserPageParamsDTO;
import com.example.serve.entity.system.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> getPage(@Param("params") UserPageParamsDTO dto);
    Integer getTotal();
    void add(@Param("params") User user);

    User getById(@Param("id") Long id);

    void update(@Param("params") User user);

    void delete(@Param("id") Long id);

    @Select("select status from user where id = #{id}")
    Integer selectOneStatus(@Param("id") Long id);

    @Update("update user set status = #{status} where id = #{id}")
    int updateStatus(@Param("id") Long id,@Param("status") Integer status);
}
