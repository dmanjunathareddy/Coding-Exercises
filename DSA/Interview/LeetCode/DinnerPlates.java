package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DinnerPlates {
    private int capacity;
    private List<List<Integer>> stacks;
    private TreeSet<Integer> availableStacks; // Keeps track of stacks with available space
    private TreeSet<Integer> nonEmptyStacks; // Keeps track of stacks that are not empty

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.availableStacks = new TreeSet<>();
        this.nonEmptyStacks = new TreeSet<>();
    }

    public void push(int val) {
        if (availableStacks.isEmpty()) {
            stacks.add(new ArrayList<>());
            availableStacks.add(stacks.size() - 1);
        }

        int index = availableStacks.first();
        stacks.get(index).add(val);

        if (stacks.get(index).size() == capacity) {
            availableStacks.remove(index);
        }
        nonEmptyStacks.add(index);
    }

    public int pop() {
        if (nonEmptyStacks.isEmpty()) return -1;

        int index = nonEmptyStacks.last();
        int val = stacks.get(index).remove(stacks.get(index).size() - 1);

        if (stacks.get(index).isEmpty()) {
            nonEmptyStacks.remove(index);
        }
        availableStacks.add(index);

        return val;
    }

    public int popAtStack(int index) {
        if (index >= stacks.size() || stacks.get(index).isEmpty()) return -1;

        int val = stacks.get(index).remove(stacks.get(index).size() - 1);

        if (stacks.get(index).isEmpty()) {
            nonEmptyStacks.remove(index);
        } else {
            nonEmptyStacks.add(index);
        }
        availableStacks.add(index);

        return val;
    }

    public static void main(String[] args) {
        DinnerPlates dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);
        System.out.println(dinnerPlates.popAtStack(0)); // Outputs 2
        dinnerPlates.push(20);
        dinnerPlates.push(21);
        System.out.println(dinnerPlates.popAtStack(0)); // Outputs 20
        System.out.println(dinnerPlates.popAtStack(2)); // Outputs 21
        System.out.println(dinnerPlates.pop()); // Outputs 5
        System.out.println(dinnerPlates.pop()); // Outputs 4
        System.out.println(dinnerPlates.pop()); // Outputs 3
        System.out.println(dinnerPlates.pop()); // Outputs 1
    }
}
