package com.example.rgshopping.po;

public class Address {
private Integer address_id;
public Integer getAddress_id() {
	return address_id;
}
public void setAddress_id(Integer address_id) {
	this.address_id = address_id;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
private String place;
private Integer user_id;
}
