package com.example.rgshopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.rgshopping.po.User;

@Mapper

public interface UserMapper {

	@Insert("insert into user (user_name, tel1, password) VALUES (#{user_name}, #{tel1}, #{password})")
	public void insertUser( User user);
	
	@Select("SELECT * FROM user WHERE tel1 = #{tel1}")  

	public User selectUserByTelephone(String tel1);

	@Select("select * from user where user_id=#{user_id}" )
	public List<User> appearUserMessage(int user_id);

}
