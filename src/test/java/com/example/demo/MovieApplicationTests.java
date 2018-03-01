package com.example.demo;

import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
//		userService.addUser("abcd","123456","hahah","12345678910");
//		System.out.println(userService.getUsers(null,null).get(0).getName());
//		System.out.println(userService.updateUserByName("abcd","123456789"));
		userService.deleteById(1);
	}

}
