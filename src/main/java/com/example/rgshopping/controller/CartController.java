package com.example.rgshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rgshopping.po.Cart;
import com.example.rgshopping.po.Product;
import com.example.rgshopping.service.ICartService;


@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private ICartService cartService;
	
	@RequestMapping("/cartmessage")
	public List<Cart> getCartMessage(@RequestBody Cart cart)
	{
    	return cartService.getCartMessage(cart.getUser_id());
	}
	@RequestMapping("/insercartmessage")
    public int insercartmessage(@RequestBody Cart cart)
    {
    	return cartService.insercartmessage(cart);
    }
    
}