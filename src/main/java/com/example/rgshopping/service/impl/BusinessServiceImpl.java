package com.example.rgshopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rgshopping.mapper.BusinessMapper;
import com.example.rgshopping.po.Business;
import com.example.rgshopping.service.IBusinessService;
;
@Service
public class BusinessServiceImpl implements IBusinessService{
	@Autowired
	private BusinessMapper businessMapper;
	@Override
	public Business getBusinessById(Business bus) {
		return businessMapper.getBusinessById(bus);
	}

}
