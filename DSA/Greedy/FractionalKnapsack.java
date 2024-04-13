package com.softgroup.dsa.greedy;

import java.util.*;

class Item {
	int weight, value;

	Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	double valueToWeightRatio() {
		return (double) value / weight;
	}
}

public class FractionalKnapsack {

	public static double fractionalKnapsack(List<Item> items, int capacity) {
		// Sort items by value-to-weight ratio in descending order
		items.sort((a, b) -> Double.compare(b.valueToWeightRatio(), a.valueToWeightRatio()));

		double totalValue = 0.0;

		for (Item item : items) {
			if (capacity > 0) {
				if (item.weight <= capacity) {
					// Take the whole item
					totalValue += item.value;
					capacity -= item.weight;
				} else {
					// Take only a fraction of the item
					totalValue += item.valueToWeightRatio() * capacity;
					capacity = 0; // Knapsack is full
				}
			}
		}
		return totalValue;
	}

	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();
		items.add(new Item(10, 60));
		items.add(new Item(20, 100));
		items.add(new Item(30, 120));

		int capacity = 50;
		double maxTotalValue = fractionalKnapsack(items, capacity);
		System.out.println("Maximum total value in the knapsack: " + maxTotalValue);
	}
}
