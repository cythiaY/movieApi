package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.User;
import com.example.demo.dto.PageDTO;
import com.example.demo.mapper.UserMapper;
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
    public boolean addUser(String userName, String userPassword, String userNickName, Integer userType, String userPhone) {
        if (userMapper.selectByUserName(userName) != null) {
            return false;
        } else {
            User user = new User();
            user.setName(userName);
            user.setPassword(userPassword);
            user.setType(userType);
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

    public boolean updateUserById(Integer id, String nickname, String phone, Integer type) {
        User user = userMapper.selectByUserId(id);
        user.setNickname(nickname);
        user.setPhone(phone);
        user.setType(type);
        return updateById(user);
    }

    public boolean updatePsdById(Integer id, String psdBefore, String psdAfter) {
        User user = userMapper.selectByUserId(id);
        if (user.getPassword().equals(psdBefore)) {
            user.setPassword(psdAfter);
            return updateById(user);
        } else {
            return false;
        }
    }

    public User selectByUserId(Integer userId) {
        return userMapper.selectByUserId(userId);
    }

    public PageDTO<User> getUsers(String name, String phone, String keyword, Integer pageNo, Integer pageSize) {
        Page<User> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(pageSize);
        List<User> users = userMapper.getUsers(page, name, phone, keyword);
        PageDTO<User> pageDTO = new PageDTO<>();
        pageDTO.setCurrent(pageNo);
        pageDTO.setSize(pageSize);
        pageDTO.setTotal(page.getTotal());
        pageDTO.setRecords(users);
        return pageDTO;
    }

    public Integer login(String name, String password) {
        User user = userMapper.login(name, password);
        if (user != null) {
            return user.getId();
        } else {
            return null;
        }
    }

    public boolean starMovie(Integer userId, Integer movieId, Boolean tag) {
        User user = userMapper.selectByUserId(userId);
        // 添加收藏
        if (tag) {
            if (user.getStar() != null) {
                if (!(user.getStar().toString().contains(movieId.toString() + ':'))) {
                    user.setStar(user.getStar().toString() + movieId.toString() + ':');
                }
            } else {
                user.setStar(movieId.toString() + ':');
            }
        } else {   //取消收藏
            String before = user.getStar();
            Integer index = user.getStar().indexOf(movieId.toString() + ':');
            String after = before.substring(0, index) + before.substring(index + movieId.toString().length() + 1, before.length());
            System.out.print(after);
            user.setStar(after);
        }
        return updateById(user);
    }

    public boolean scoreMovie(Integer userId, Integer movieId) {
        User user = userMapper.selectByUserId(userId);
        if (user.getScore() != null) {
            if (!(user.getScore().toString().contains(movieId.toString() + ':'))) {
                user.setScore(user.getScore().toString() + movieId.toString() + ':');
            }
        } else {
            user.setScore(movieId.toString() + ':');
        }
        return updateById(user);
    }
}
