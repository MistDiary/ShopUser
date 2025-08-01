package com.example.rgshopping.service;

import java.util.List;

import com.example.rgshopping.po.Product;



public interface IProductService {
	public List<Product> listProduct();
	
	public List<Product> listProductByPro_category(String pro_category);
	
	public Product getProductById(Product pro);
	
	public List<Product> listProductByName( String search);
	public List<Product> listProductByBus_id(Product pro);
}
