package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class SkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev = 0;
        
        for (int[] height : heights) {
            if (height[1] < 0) {
                pq.offer(-height[1]);
            } else {
                pq.remove(height[1]);
            }
            
            int curr = pq.peek();
            if (prev != curr) {
                result.add(new int[]{height[0], curr});
                prev = curr;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        SkylineProblem sp = new SkylineProblem();
        int[][] buildings = {
            {2, 9, 10}, 
            {3, 7, 15}, 
            {5, 12, 12}, 
            {15, 20, 10}, 
            {19, 24, 8}
        };
        List<int[]> skyline = sp.getSkyline(buildings);
        for (int[] point : skyline) {
            System.out.println(Arrays.toString(point));
        }
        // Output: [[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]
    }
}
