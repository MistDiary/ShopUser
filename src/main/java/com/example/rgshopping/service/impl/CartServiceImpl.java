package com.example.rgshopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rgshopping.mapper.CartMapper;
import com.example.rgshopping.po.Cart;
import com.example.rgshopping.service.ICartService;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartMapper cartMapper;
	private List<Cart> add1;
	@Override
	public List<Cart> getCartMessage(int userId)
	{
    	return cartMapper.getCartMessage(userId);
	}
	
	@Override
	public int insercartmessage(Cart cart)
	{
    	int n=0;
    	int m=0;
    	add1=cartMapper.getCartMessage(cart.getUser_id());
    	for(int i=0;i<add1.size();i++)
    	{
    		m=add1.get(i).getCartId();
    		if(m>n) {n=m;}
    	}
    	cart.setCartId(n+1);
    	return cartMapper.insercartmessage(cart);
	}
}
