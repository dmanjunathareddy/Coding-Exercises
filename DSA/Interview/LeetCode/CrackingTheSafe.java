package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class CrackingTheSafe {

    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        String start = String.join("", Collections.nCopies(n - 1, "0"));
        dfs(sb, visited, start, n, k);
        sb.append(start);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, Set<String> visited, String node, int n, int k) {
        for (int i = 0; i < k; i++) {
            String next = node + i;
            if (!visited.contains(next)) {
                visited.add(next);
                dfs(sb, visited, next.substring(1), n, k);
                sb.append(i);
            }
        }
    }

    public static void main(String[] args) {
        CrackingTheSafe solution = new CrackingTheSafe();
        System.out.println(solution.crackSafe(2, 2)); // Output: "00110" or any other valid sequence
    }
}
