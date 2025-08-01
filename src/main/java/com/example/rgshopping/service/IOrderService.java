package com.example.rgshopping.service;

import java.util.List;

import com.example.rgshopping.po.Order;
import com.example.rgshopping.po.Order_item;


public interface IOrderService {
	public List<Order> appearorderMessage(int user_id);
	public List<Order_item> appearOrderDetailsMessage(int order_id);
}