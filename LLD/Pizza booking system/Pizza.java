package com.softgroup.lld.pizzabookingsystem;

public class Pizza {
	int pizzaId;
	String name;
	String description;
	double price;

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	void getDetails() {
		// Implementation
	}

	double calculatePrice() {
		return 10.0;
	}
}
