package com.example.rgshopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rgshopping.mapper.AddressMapper;
import com.example.rgshopping.po.Address;
import com.example.rgshopping.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{
	@Autowired
	private AddressMapper addressMapper;
	private List<Address> add;
    @Override
    public List<Address> appearAddressMessage(int user_id)
    {
    	return addressMapper.appearAddressMessage(user_id);
    }
    @Override
	public int deleteaddressmessage(int address_id)
	{
    	return addressMapper.deleteaddressmessage(address_id);
	}
    @Override
	public int inserAddress(Address address) {
    
    	int n=0;
    	int m=0;
    	add=addressMapper.appearAddressMessage(address.getUser_id());
    	for(int i=0;i<add.size();i++)
    	{
    		m=add.get(i).getAddress_id();
    		if(m>n) {n=m;}
    	}
        address.setAddress_id(n+1);
    	return addressMapper.inserAddress(address);

    }
}
