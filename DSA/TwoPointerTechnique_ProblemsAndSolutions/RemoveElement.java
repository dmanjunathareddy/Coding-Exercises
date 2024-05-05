package com.softgroup.dsa.greedy.twopointer;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLength = removeElement(nums, val);
        System.out.println("New Length: " + newLength); // Output: 2
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " "); // Output: 2 2
        }
    }
}
