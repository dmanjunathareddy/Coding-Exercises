package com.softgroup.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, results, new ArrayList<>(), 0);
        return results;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> results, List<Integer> combination, int start) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], results, combination, i);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> results = combinationSum.combinationSum(candidates, target);
        for (List<Integer> combination : results) {
            System.out.println(combination);
        }
    }
}

