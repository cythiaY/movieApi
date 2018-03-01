package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.domain.User;
import com.sun.tools.javac.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Summer on 2017/12/9.
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> getUsers(@Param("name") String name, @Param("nickname") String nickname);

    User selectByUserName(@Param("userName") String name);

    boolean updateUserByName(@Param("name") String name,@Param("phone")String phone);

}
