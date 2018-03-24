package com.example.demo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Summer on 2017/12/9.
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增普通用户（type：2）
     * ID自增
     *
     * @param userName：登录名
     * @param userPassword ：登录密码
     */
    public boolean addUser(String userName, String userPassword, String userNickName, String userPhone) {
        if (userMapper.selectByUserName(userName) != null) {
            return false;
        } else {
            User user = new User();
            user.setName(userName);
            user.setPassword(userPassword);
            user.setType(2);
            if (userNickName != "") {
                user.setNickname(userNickName);
            }
            if (userPhone != "") {
                user.setPhone(userPhone);
            }
            user.setCreateTime(new Date());
            return insert(user);
        }
    }

//    public boolean updateUser(String userName, String userPassword, String nickName, String userPhone, Integer userHobby) {
//        User user = userMapper.selectByUserName(userName);
//        if (user != null) {
//            user.setPassword(userPassword);
//            user.setNickname(nickName);
//            user.setPhone(userPhone);
//            user.setHobby(userHobby);
//            return updateById(user);
//        }
//        return false;
//    }

    public boolean updateUserByName(String name, String phone) {
        User user = userMapper.selectByUserName(name);
        System.out.println(user.getId());
        System.out.println(user.getName());
        user.setPhone(phone);
        return updateById(user);
    }

    public List<User> getUsers(String name, String phone) {
        return userMapper.getUsers(name, phone);
    }

    public boolean login(String name, String password) {
        if (userMapper.login(name, password) != null) {
            return true;
        } else {
            return false;
        }
    }


}
