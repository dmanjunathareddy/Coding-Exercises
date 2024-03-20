package com.softgroup.dsa.sliding;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
	public static int totalFruit(int[] tree) {
		if (tree == null || tree.length == 0)
			return 0;

		int maxFruits = 0;
		int start = 0;
		Map<Integer, Integer> basket = new HashMap<>(); // Key: fruit type, Value: count

		for (int end = 0; end < tree.length; end++) {
			int fruit = tree[end];
			basket.put(fruit, basket.getOrDefault(fruit, 0) + 1); // Add current fruit to basket

			// If the size of the basket exceeds 2, move start pointer until size becomes 2
			while (basket.size() > 2) {
				int leftFruit = tree[start];
				basket.put(leftFruit, basket.get(leftFruit) - 1);
				if (basket.get(leftFruit) == 0)
					basket.remove(leftFruit);
				start++;
			}

			maxFruits = Math.max(maxFruits, end - start + 1);
		}

		return maxFruits;
	}

	public static void main(String[] args) {
		int[] fruits = { 1, 2, 1, 3, 4, 3, 5, 1, 2 }; // Example input
		int result = totalFruit(fruits);
		System.out.println("Maximum number of fruits: " + result);
	}
}
