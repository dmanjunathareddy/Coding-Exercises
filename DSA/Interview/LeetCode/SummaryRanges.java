package com.softgroup.dsa.interview.leetcode;
import java.util.TreeMap;
import java.util.Map;

public class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {
        if (intervals.containsKey(val)) {
            return; // The value is already in the intervals
        }

        // Get the intervals just before and after the current value
        Integer lowerKey = intervals.lowerKey(val);
        Integer higherKey = intervals.higherKey(val);

        boolean mergeWithLower = lowerKey != null && intervals.get(lowerKey) + 1 >= val;
        boolean mergeWithHigher = higherKey != null && higherKey - 1 <= val;

        if (mergeWithLower && mergeWithHigher) {
            // Merge both intervals
            intervals.put(lowerKey, intervals.get(higherKey));
            intervals.remove(higherKey);
        } else if (mergeWithLower) {
            // Merge with the lower interval
            intervals.put(lowerKey, Math.max(intervals.get(lowerKey), val));
        } else if (mergeWithHigher) {
            // Merge with the higher interval
            int end = intervals.get(higherKey);
            intervals.remove(higherKey);
            intervals.put(val, end);
        } else {
            // No merging, add as a new interval
            intervals.put(val, val);
        }
    }

    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        summaryRanges.addNum(3);
        summaryRanges.addNum(7);
        summaryRanges.addNum(2);
        summaryRanges.addNum(6);

        int[][] intervals = summaryRanges.getIntervals();
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
