package com.example.rgshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rgshopping.po.Cart;
import com.example.rgshopping.po.Order;
import com.example.rgshopping.po.Order_item;
import com.example.rgshopping.po.Product;
import com.example.rgshopping.service.IOrderService;
import com.example.rgshopping.service.IProductService;



@RestController
@RequestMapping("/cart")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	   @RequestMapping("/all")
		public List<Order> appearorderMessage(@RequestBody Order order)
	    {return orderService.appearorderMessage(order.getUser_id());}
	    @RequestMapping("/appearorderDetailsMessage")
		public List<Order_item> appearorderDetailsMessage(@RequestBody Order_item order_item)
	    {return orderService.appearOrderDetailsMessage(order_item.getOrder_id());
	}
    
}