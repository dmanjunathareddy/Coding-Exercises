package com.softgroup.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static List<Integer> findLeaders(int[] nums) {
        List<Integer> leaders = new ArrayList<>();
        
        if (nums.length == 0) {
            return leaders;
        }
        
        int maxFromRight = nums[nums.length - 1];
        leaders.add(maxFromRight);
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > maxFromRight) {
                maxFromRight = nums[i];
                leaders.add(maxFromRight);
            }
        }
        
        return leaders;
    }
    
    public static void main(String[] args) {
        int[] nums = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders = findLeaders(nums);
        
        System.out.println("Leaders in the array are: " + leaders);
    }
}
