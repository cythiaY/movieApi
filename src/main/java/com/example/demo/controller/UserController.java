package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.utils.ResponseDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Summer on 2017/12/11.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     */
    @RequestMapping("/add")
    public ResponseDO adduser(@RequestParam(value = "userName", required = true) String userName,
                              @RequestParam(value = "userPassword", required = true) String userPsd,
                              @RequestParam(value = "userNickName", required = false) String userNickName,
                              @RequestParam(value = "userType", required = true) Integer userType,
                              @RequestParam(value = "userPhone", required = false) String userPhone
    ) {
        return new ResponseDO(userService.addUser(userName, userPsd, userNickName, userType, userPhone));
    }

    /**
     * 修改用户
     */
    @RequestMapping("/update")
    public ResponseDO updateUser(@RequestParam(value = "userId", required = true) Integer userId,
                                 @RequestParam(value = "userNickname", required = false) String userNickname,
                                 @RequestParam(value = "type", required = false) Integer type,
                                 @RequestParam(value = "userPhone", required = false) String userPhone
    ) {

        boolean result = userService.updateUserById(userId, userNickname, userPhone, type);
        return new ResponseDO(result);
    }

    /**
     * 修改密码
     */
    @RequestMapping("/resetPsd")
    public ResponseDO updateUserPsd(
            @RequestParam(value = "userId") Integer userId,
            @RequestParam(value = "passwordBefore") String passwordBefore,
            @RequestParam(value = "passwordAfter") String passwordAfter
    ) {
        boolean result = userService.updatePsdById(userId, passwordBefore, passwordAfter);
        return new ResponseDO(result);
    }

    /**
     * 查询用户列表
     */
    @RequestMapping("/getUsers")
    public ResponseDO getUsers(@RequestParam(value = "userName", required = false) String userName,
                               @RequestParam(value = "userPhone", required = false) String userPhone,
                               @RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "page_no", required = false, defaultValue = "1") Integer pageNo,
                               @RequestParam(value = "page_size", required = false, defaultValue = "10") Integer pageSize
    ) {
        return new ResponseDO(userService.getUsers(userName, userPhone, keyword, pageNo, pageSize));
    }

    /**
     * 查询用户信息
     */
    @RequestMapping("/getUserInfo")
    public ResponseDO getUserInfo(@RequestParam(value = "userId", required = true) Integer id) {
        return new ResponseDO(userService.selectByUserId(id));
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseDO login(@RequestParam(value = "userName") String userName,
                            @RequestParam(value = "userPassword") String userPassword
    ) {
        return new ResponseDO(userService.login(userName, userPassword));
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete/user")
    public ResponseDO deleteUser(@RequestParam(value = "id") Integer id) {
        return new ResponseDO(userService.deleteById(id));
    }

    /**
     * 收藏电影
     * tag : true 收藏  false 取消收藏
     */
    @RequestMapping(value = "/starMovie")
    public ResponseDO starMovie(@RequestParam(value = "userId") Integer userId,
                                @RequestParam(value = "movieId") Integer movieId,
                                @RequestParam(value = "tag") Boolean tag) {
        return new ResponseDO(userService.starMovie(userId, movieId, tag));
    }
}
