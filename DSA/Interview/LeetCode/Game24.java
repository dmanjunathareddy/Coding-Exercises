package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.List;

public class Game24 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }
        
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    List<Double> nextRound = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            nextRound.add(list.get(k));
                        }
                    }
                    for (double d : compute(list.get(i), list.get(j))) {
                        nextRound.add(d);
                        if (solve(nextRound)) {
                            return true;
                        }
                        nextRound.remove(nextRound.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (b != 0) {
            res.add(a / b);
        }
        if (a != 0) {
            res.add(b / a);
        }
        return res;
    }

    public static void main(String[] args) {
        Game24 game = new Game24();
        int[] nums = {4, 1, 8, 7}; // Example test case
        System.out.println(game.judgePoint24(nums)); // true
    }
}
