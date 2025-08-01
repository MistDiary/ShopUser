package com.example.rgshopping.service;

import java.util.List;

import com.example.rgshopping.po.Cart;
import com.example.rgshopping.po.Product;

public interface ICartService {
	public List<Cart> getCartMessage(int user_id);
	public int insercartmessage(Cart cart);
}
