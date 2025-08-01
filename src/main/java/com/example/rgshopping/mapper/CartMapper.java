package com.example.rgshopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.rgshopping.po.Cart;
import com.example.rgshopping.po.Product;

@Mapper
public interface CartMapper {

	public List<Cart> listCart(Cart cart);

	@Select("select * from cart where user_id=#{user_id}" )
	public List<Cart> getCartMessage(int user_id);
	@Insert("insert into cart(pro_num,pro_id,bus_id,user_id,cartId,pro_price,pro_image,pro_name,bus_name) values(#{pro_num},#{pro_id},#{bus_id},#{user_id},#{cartId},#{pro_price},#{pro_image},#{pro_name},#{bus_name})" )
	public int insercartmessage(Cart cart);

}
