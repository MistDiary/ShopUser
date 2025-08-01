package com.example.rgshopping.service;

import java.util.List;

import com.example.rgshopping.po.User;

public interface IUserService {

	public void insertUser(User user);

	public Integer checkUserByPassword(String tel1, String password);
	public  List<User> appearUserMessage(int user_id);

}
