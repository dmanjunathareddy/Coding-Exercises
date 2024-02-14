package com.softgroup.dsa.bitmanipulation;

public class SetBitsCounter {
	public static int countSetBits(int num) {
		int count = 0;
		while (num != 0) {
			count += num & 1;
			num >>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int number = 25;
		System.out.println("Number of set bits in " + number + ": " + countSetBits(number));
	}
}
