package com.example.rgshopping.po;

public class Order_item {
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getPro_id() {
		return pro_id;
	}
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}
	public Integer getPro_num() {
		return Pro_num;
	}
	public void setPro_num(Integer pro_num) {
		Pro_num = pro_num;
	}
	public String getState2() {
		return state2;
	}
	public void setState2(String state2) {
		this.state2 = state2;
	}
	private Integer item_id;
	private Integer order_id;
	private Integer pro_id;
	private Integer Pro_num;
	private String state2;
}
