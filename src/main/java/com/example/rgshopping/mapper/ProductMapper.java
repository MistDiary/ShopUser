package com.example.rgshopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.rgshopping.po.Product;

@Mapper
public interface ProductMapper {

	@Select("select * from product ")
	public List<Product> listProduct();

	@Select("select * from product where category=#{pro_category}")

	public List<Product> listProductByPro_category(String pro_category);

	@Select("select * from product where pro_id=#{pro_id}")
	public Product getProductById(Product pro);

	@Select("SELECT * from product where pro_name LIKE CONCAT('%', #{pro_name}, '%')")
	public List<Product> listProductByName(@Param("pro_name") String pro_name);

	@Select("select * from product where bus_id=#{bus_id}")
	public List<Product> listProductByBus_id(Product pro);
}
