package com.example.rgshopping.service;

import java.util.List;

import com.example.rgshopping.po.Address;

public interface IAddressService {
	public List<Address> appearAddressMessage(int user_id);
	public int deleteaddressmessage(int address_id);
	public int inserAddress(Address address);
}
