package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    
    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        
        // Create an array of factorial lookup
        int fact = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            factorial[i] = fact;
        }
        
        // Create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // Adjust k to be zero-based
        k--;

        StringBuilder sb = new StringBuilder();
        
        // Build the k-th permutation sequence
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(getPermutation(n, k)); // Output: "2314"
    }
}
