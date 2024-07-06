package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class SmallestRange {
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;
        
        // Initialize the heap with the first element from each list
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.add(new Element(value, i, 0));
            max = Math.max(max, value);
        }
        
        while (minHeap.size() == nums.size()) {
            Element current = minHeap.poll();
            int min = current.value;
            
            // Update the range if it's smaller than the current range
            if (max - min < end - start) {
                start = min;
                end = max;
            }
            
            // Move to the next element in the same list
            if (current.index + 1 < nums.get(current.list).size()) {
                current.index++;
                current.value = nums.get(current.list).get(current.index);
                minHeap.add(current);
                max = Math.max(max, current.value);
            }
        }
        
        return new int[]{start, end};
    }

    static class Element {
        int value;
        int list;
        int index;
        
        Element(int value, int list, int index) {
            this.value = value;
            this.list = list;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        int[] range = smallestRange(nums);
        System.out.println("Smallest range is: [" + range[0] + ", " + range[1] + "]");
    }
}
