package com.example.rgshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rgshopping.po.Address;
import com.example.rgshopping.service.IAddressService;






@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private IAddressService addressService;
	
	 @RequestMapping("/addressmessage")
	    public List<Address> appearAddressMessage(@RequestBody Address address )
	    {
	    	return addressService.appearAddressMessage(address.getUser_id());
	    }
	  @RequestMapping("/deladdress")
	    public int deleteaddressmessage(@RequestBody Address address)
	    {
	    	return addressService.deleteaddressmessage(address.getAddress_id());
	    }
	    @RequestMapping("/insertaddressmessage")
	    public int inserAddress(@RequestBody Address address)
	    {
	    	return addressService.inserAddress(address);
	    }
}
