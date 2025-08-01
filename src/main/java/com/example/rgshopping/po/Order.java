package com.example.rgshopping.po;

public class Order {
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getT_money() {
		return t_money;
	}

	public void setT_money(String t_money) {
		this.t_money = t_money;
	}

	private  Integer order_id;
	private Integer user_id;
	private Integer address_id;
	private String state;

	private String t_money;
}
