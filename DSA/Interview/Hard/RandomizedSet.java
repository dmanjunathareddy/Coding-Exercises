package com.softgroup.dsa.interview;
import java.util.*;

public class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    // Inserts an element into the set. Returns true if the element was inserted, false if it was already present.
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    // Removes an element from the set. Returns true if the element was removed, false if it was not present.
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Swap the last element with the element to remove
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    // Returns a random element from the set.
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.insert(1)); // false
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.remove(1)); // false
        System.out.println(randomizedSet.getRandom()); // Should be 2 as it's the only element
    }
}
