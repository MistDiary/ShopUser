package com.example.rgshopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.rgshopping.po.Address;




@Mapper
public interface AddressMapper {

	@Select("select * from address where user_id=#{user_id}" )
	public List<Address> appearAddressMessage(int user_id);
	@Delete("delete from address where address_id=#{address_id}")
	public int deleteaddressmessage(int address_id);
	@Insert("insert into address(address_id,place,user_id) values(#{address_id},#{place},#{user_id})" )
	public int inserAddress(Address address);
	
}
