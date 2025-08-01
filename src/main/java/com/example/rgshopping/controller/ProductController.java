package com.example.rgshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rgshopping.po.Product;
import com.example.rgshopping.service.IProductService;

@RestController
@RequestMapping("/product")

public class ProductController {

	@Autowired
	private IProductService productService;
	@RequestMapping("/listProduct")
	public List<Product> listProduct(){
		return productService.listProduct();
	}
	
	@RequestMapping("/listProductByPro_category")
	public List<Product> listProductByPro_category(@RequestBody Product product){
		return productService.listProductByPro_category( product.getCategory());
	}
	
	@RequestMapping("/getProductById")
	public Product getProductById(@RequestBody  Product pro) {
		return productService.getProductById(pro);
	}
	@RequestMapping("/listProductByName")
	public List<Product> listProductByName( @RequestParam  String pro_name){
		return productService.listProductByName(pro_name);
	}
	@RequestMapping("/listProductByBus_id")
	public List<Product> listProductByBus_id(@RequestBody Product pro){
		return productService.listProductByBus_id(pro);
	}
	
}