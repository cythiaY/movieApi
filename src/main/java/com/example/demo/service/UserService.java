package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Movie;
import com.example.demo.domain.User;
import com.example.demo.dto.PageDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean updateUserById(Integer id, String nickname, String phone) {
        User user = userMapper.selectByUserId(id);
        user.setNickname(nickname);
        user.setPhone(phone);
        return updateById(user);
    }

    public boolean updatePsdById(Integer id, String psdBefore, String psdAfter) {
        User user = userMapper.selectByUserId(id);
        System.out.println((user.getPassword().toString() == psdBefore.toString()) + "::" + psdAfter);
        if (user.getPassword() == psdBefore) {
            user.setPassword(psdAfter);
            return updateById(user);
        } else {
            return false;
        }
    }

    public User selectByUserId(Integer userId) {
        return userMapper.selectByUserId(userId);
    }

    public PageDTO<User> getUsers(String name, String phone, Integer pageNo, Integer pageSize) {
        Page<User> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(pageSize);
        List<User> users = userMapper.getUsers(page, name, phone);
        PageDTO<User> pageDTO = new PageDTO<>();
        pageDTO.setCurrent(pageNo);
        pageDTO.setSize(pageSize);
        pageDTO.setTotal(page.getTotal());
        pageDTO.setRecords(users);
        return pageDTO;
    }

    public Integer login(String name, String password) {
        User user = userMapper.login(name, PasswordUtils.getStudentPassword(password));
        if (user != null) {
            return user.getId();
        } else {
            return null;
        }
    }


}
