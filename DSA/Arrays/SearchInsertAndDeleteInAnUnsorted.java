package com.softgroup.dsa.arrays;

public class SearchInsertAndDeleteInAnUnsorted {
	private int[] arr;
	private int size;
	private int capacity;

	public SearchInsertAndDeleteInAnUnsorted(int capacity) {
		this.arr = new int[capacity];
		this.size = 0;
		this.capacity = capacity;
	}

	public boolean search(int key) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == key) {
				return true;
			}
		}
		return false;
	}

	public void insert(int key) {
		if (size < capacity) {
			arr[size++] = key;
		} else {
			System.out.println("Array is full. Cannot insert element.");
		}
	}

	public void delete(int key) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (arr[i] == key) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			for (int i = index; i < size - 1; i++) {
				arr[i] = arr[i + 1];
			}
			size--;
			System.out.println("Element " + key + " deleted successfully.");
		} else {
			System.out.println("Element " + key + " not found in the array.");
		}
	}

	public void display() {
		System.out.print("Array elements: ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SearchInsertAndDeleteInAnUnsorted array = new SearchInsertAndDeleteInAnUnsorted(5);
		array.insert(3);
		array.insert(7);
		array.insert(1);
		array.insert(5);
		array.display();
		System.out.println("Is 7 present in the array? " + array.search(7));
		System.out.println("Is 10 present in the array? " + array.search(10));
		array.delete(7);
		array.display();
	}
}
