package com.softgroup.dsa.arrays;

public class MajorityElement {
    public static int findMajorityElement(int[] nums) {
        int count = 0;
        int majorityElement = nums[0];
        
        for (int num : nums) {
            if (count == 0) {
                majorityElement = num;
                count++;
            } else if (majorityElement == num) {
                count++;
            } else {
                count--;
            }
        }
        
        return majorityElement;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4}; // Example array
        int majorityElement = findMajorityElement(nums);
        System.out.println("Majority Element is: " + majorityElement);
    }
}
