package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class RandomizedCollection {
    private Map<Integer, Set<Integer>> idxMap;
    private List<Integer> nums;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        idxMap = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean notContained = !idxMap.containsKey(val);
        if (notContained) {
            idxMap.put(val, new HashSet<>());
        }
        idxMap.get(val).add(nums.size());
        nums.add(val);
        return notContained;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idxMap.containsKey(val) || idxMap.get(val).isEmpty()) {
            return false;
        }
        int removeIdx = idxMap.get(val).iterator().next();
        idxMap.get(val).remove(removeIdx);
        int lastVal = nums.get(nums.size() - 1);
        nums.set(removeIdx, lastVal);
        if (removeIdx != nums.size() - 1) {
            idxMap.get(lastVal).remove(nums.size() - 1);
            idxMap.get(lastVal).add(removeIdx);
        }
        nums.remove(nums.size() - 1);
        if (idxMap.get(val).isEmpty()) {
            idxMap.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(1)); // true
        System.out.println(collection.insert(1)); // false
        System.out.println(collection.insert(2)); // true
        System.out.println(collection.getRandom()); // 1 or 2
        System.out.println(collection.remove(1)); // true
        System.out.println(collection.getRandom()); // 1 or 2
    }
}
