package com.example.rgshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rgshopping.po.Business;
import com.example.rgshopping.service.IBusinessService;




@RestController
@RequestMapping("/business")
public class BusinessController {
	@Autowired
	private IBusinessService businessService;
	
	@RequestMapping("/getBusinessById")
	public Business getBusinessById(@RequestBody Business bus) {
		return businessService.getBusinessById(bus);
	}
}
