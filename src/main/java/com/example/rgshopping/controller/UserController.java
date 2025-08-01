package com.example.rgshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rgshopping.po.User;
import com.example.rgshopping.service.IUserService;

@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	private IUserService userService; 
	@RequestMapping("/insertUser")
	public void insertUser(@RequestBody User user){
		userService.insertUser(user);
	}

	@RequestMapping("/checkUserByPassword")
	public Integer checkUserByPassword(@RequestBody User user){
		return userService.checkUserByPassword(user.getTel1(),user.getPassword());
	}
	@RequestMapping("/usermessage")
	public List<User> appearUserMessage(@RequestBody User user ) 
        {return userService.appearUserMessage(user.getUser_id());}
	
}
