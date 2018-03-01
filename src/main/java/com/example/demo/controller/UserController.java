package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.utils.ResponseDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                              @RequestParam(value = "userPhone", required = false) String userPhone
    ) {
        return new ResponseDO(userService.addUser(userName, userPsd, userNickName, userPhone));
    }

    /**
     * 修改用户
     */
    @RequestMapping("/update")
    public ResponseDO updateUser(@RequestParam(value = "userName", required = true) String userName,
                           @RequestParam(value = "userPhone", required = true) String userPhone
    ) {

        boolean result = userService.updateUserByName(userName, userPhone);
        return new ResponseDO(result);
    }

    /**
     * 查询用户
     */
    @RequestMapping("/getUsers")
    public ResponseDO getUsers(@RequestParam(value = "userName", required = false) String userName,
                           @RequestParam(value = "userPhone", required = false) String userPhone
    ) {
        return new ResponseDO(userService.getUsers(userName, userPhone));
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete/user")
    public ResponseDO deleteUser(@RequestParam(value = "id", required = true) Integer id) {
        return new ResponseDO(userService.deleteById(id));
    }
}
