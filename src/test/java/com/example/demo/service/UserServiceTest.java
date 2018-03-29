package com.example.demo.service;

import com.example.demo.BaseTest;
import com.example.demo.MovieApplication;
import com.example.demo.domain.User;
import com.example.demo.dto.PageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;

import static org.junit.Assert.*;


public class UserServiceTest extends BaseTest{

    @Autowired
    private UserService userService;

    @Test
    public void addUser() throws Exception {
    }

    @Test
    public void updateUserByName() throws Exception {
    }

    @Test
    public void getUsers() throws Exception {
        PageDTO<User> users = userService.getUsers(null, null, 1, 10);
        System.out.println(users.getRecords().size());
    }

//    @Test
//    public void login() throws Exception {
//        boolean login = userService.login("456", "123");
//        System.out.println(login);
//    }

}