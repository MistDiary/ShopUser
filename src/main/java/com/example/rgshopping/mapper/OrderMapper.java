package com.example.rgshopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.rgshopping.po.Cart;
import com.example.rgshopping.po.Order;
import com.example.rgshopping.po.Order_item;
import com.example.rgshopping.po.Product;


@Mapper
public interface OrderMapper{

	@Select("select * from order where user_id=#{user_id}" )
	public List<Order> appearorderMessage(int user_id);
	@Select("select * from order_item where order_id=#{order_id}" )
	public List<Order_item> appearOrderDetailsMessage(int order_id);
}
