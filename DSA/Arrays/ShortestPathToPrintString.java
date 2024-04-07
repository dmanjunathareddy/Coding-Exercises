package com.softgroup.dsa.array;

import java.util.*;

public class ShortestPathToPrintString {

    public static String shortestPath(String target) {
        int n = target.length();
        Map<Integer, String>[] dp = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashMap<>();
        }
        dp[0].put(0, "");
        for (int i = 0; i < n; i++) {
            for (int key : dp[i].keySet()) {
                // Copy all
                dp[i + 1].put(key + 1, dp[i].get(key) + " C" + target.charAt(i));
                // Paste
                if (key > 0) {
                    dp[i + 1].put(key - 1, dp[i].get(key) + " P");
                }
                // Insert
                dp[i + 1].put(key + 1, dp[i].get(key) + " I" + target.charAt(i));
                // Delete
                dp[i + 1].put(key, dp[i].get(key) + " D");
            }
        }
        int minSteps = Integer.MAX_VALUE;
        String minPath = "";
        for (int key : dp[n].keySet()) {
            if (key >= 0 && key < minSteps) {
                minSteps = key;
                minPath = dp[n].get(key);
            }
        }
        return minPath;
    }

    public static void main(String[] args) {
        String target = "programming";
        String path = shortestPath(target);
        System.out.println("Shortest path to print '" + target + "': " + path);
    }
}
