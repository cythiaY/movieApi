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
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequestMapping("/add")
    public ResponseDO adduser(@RequestParam(value = "userName", required = true) String userName,
                              @RequestParam(value = "userPassword", required = true) String userPsd,
                              @RequestParam(value = "userNickName", required = false) String userNickName,
                              @RequestParam(value = "userPhone", required = false) String userPhone
    ) {
        return new ResponseDO(userService.addUser(userName, userPsd, userNickName, userPhone));
    }

    /**
     * 修改用户
     */
    @RequestMapping("/update")
    public ResponseDO updateUser(@RequestParam(value = "userId", required = true) Integer userId,
                                 @RequestParam(value = "userPhone", required = true) String userPhone
    ) {

        boolean result = userService.updateUserById(userId, userPhone);
        return new ResponseDO(result);
    }

    /**
     * 查询用户列表
     */
    @RequestMapping("/getUsers")
    public ResponseDO getUsers(@RequestParam(value = "userName", required = false) String userName,
                               @RequestParam(value = "userPhone", required = false) String userPhone
    ) {
        return new ResponseDO(userService.getUsers(userName, userPhone));
    }

    /**
     * 查询用户信息
     */
    @RequestMapping("/getUserInfo")
    public ResponseDO getUserInfo(@RequestParam(value = "id", required = true) Integer id){
        return new ResponseDO(userService.selectByUserId(id));
    }
    /**
     * 登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResponseDO login(@RequestParam(value = "userName", required = true) String userName,
                            @RequestParam(value = "userPassword", required = true) String userPassword
    ) {
        return new ResponseDO(userService.login(userName, userPassword));
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete/user")
    public ResponseDO deleteUser(@RequestParam(value = "id", required = true) Integer id) {
        return new ResponseDO(userService.deleteById(id));
    }
}
