package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Summer on 2017/12/9.
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> getUsers(@Param("name") String name, @Param("phone") String phone);
    User login(@Param("name") String name, @Param("password") String password);

    User selectByUserId(@Param("userId") Integer userId);
    User selectByUserName(@Param("userName") String name);

    boolean updateUserById(@Param("userId") String userId,@Param("phone")String phone);
}
