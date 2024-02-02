package com.softgroup.lld.pizzabookingsystem;

import java.util.List;

public class Customer {
	int customerId;
	String name;
	String address;
	String phone;

	public Customer(int customerId, String name, String address, String phone) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	void placeOrder(List<Pizza> pizzas) {
		// Implementation
	}

	void viewOrderHistory() {
		// Implementation
	}
}