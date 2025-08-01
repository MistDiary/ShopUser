package com.example.rgshopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rgshopping.mapper.UserMapper;
import com.example.rgshopping.po.User;
import com.example.rgshopping.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public Integer checkUserByPassword(String tel1, String password) {
		User user = userMapper.selectUserByTelephone(tel1);  
	    if (user != null && password.equals(user.getPassword())) {  
	        return user.getUser_id();  

	}
	    return null;  

	}
	
	public List<User> appearUserMessage(int user_id)
	{
    	return userMapper.appearUserMessage(user_id);
	}
}
