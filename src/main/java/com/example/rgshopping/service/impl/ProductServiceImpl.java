package com.example.rgshopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.rgshopping.mapper.ProductMapper;
import com.example.rgshopping.po.Product;
import com.example.rgshopping.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductMapper productMapper;
	@Override
	public List<Product> listProduct() {
		return productMapper.listProduct();
	}
	public List<Product> listProductByPro_category(String pro_category){
		return productMapper.listProductByPro_category( pro_category);
	}
	public Product getProductById(Product pro) {
		return productMapper.getProductById(pro);
	}
	
	
	public List<Product> listProductByName( String pro_name){
		return productMapper.listProductByName(pro_name);
		
	}
	public List<Product> listProductByBus_id(Product pro){
		return productMapper.listProductByBus_id(pro);
	}
	
}
