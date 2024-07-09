package com.softgroup.dsa.interview.leetcode;
import java.util.Map;
import java.util.TreeMap;

public class RangeModule {
    private TreeMap<Integer, Integer> ranges;

    public RangeModule() {
        ranges = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (left >= right) return;
        Integer start = ranges.floorKey(left);
        if (start == null) start = ranges.ceilingKey(left);
        while (start != null && start <= right) {
            int end = ranges.get(start);
            if (end >= left) {
                left = Math.min(left, start);
                right = Math.max(right, end);
                ranges.remove(start);
            }
            start = ranges.higherKey(start);
        }
        ranges.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        if (left >= right) return false;
        Integer start = ranges.floorKey(left);
        if (start == null) return false;
        return ranges.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        if (left >= right) return;
        Integer start = ranges.floorKey(left);
        if (start == null) start = ranges.ceilingKey(left);
        while (start != null && start < right) {
            int end = ranges.get(start);
            if (end >= left) {
                ranges.remove(start);
                if (start < left) ranges.put(start, left);
                if (end > right) ranges.put(right, end);
            }
            start = ranges.higherKey(start);
        }
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        System.out.println(rangeModule.queryRange(14, 16)); // true
        rangeModule.removeRange(14, 16);
        System.out.println(rangeModule.queryRange(14, 16)); // false
        System.out.println(rangeModule.queryRange(10, 14)); // true
        System.out.println(rangeModule.queryRange(16, 20)); // true
    }
}
