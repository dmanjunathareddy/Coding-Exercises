package com.softgroup.dsa.array;

public class MaxIndexExample {
    public static void main(String[] args) {
        int[] array = {10, 5, 20, 8, 15};
        int maxIndex = 0; 
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i; 
            }
        }
        System.out.println("The maximum element is at index: " + maxIndex);
    }
}
