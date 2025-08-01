package com.example.rgshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.rgshopping.po.Business;



@Mapper
public interface BusinessMapper {

	@Select("select * from business where bus_id=#{bus_id}")
	public Business getBusinessById(Business bus);
}
