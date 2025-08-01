package com.example.rgshopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rgshopping.mapper.OrderMapper;
import com.example.rgshopping.po.Order;
import com.example.rgshopping.po.Order_item;
import com.example.rgshopping.service.IOrderService;


@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderMapper orderMapper;
	private Order add;
	   @Override
		public List<Order> appearorderMessage(int user_id)
		{
	    	return orderMapper.appearorderMessage(user_id);
		}

	    public List<Order_item> appearOrderDetailsMessage(int order_id)
	    {
	    	return orderMapper.appearOrderDetailsMessage(order_id);
	    }
	   
}
