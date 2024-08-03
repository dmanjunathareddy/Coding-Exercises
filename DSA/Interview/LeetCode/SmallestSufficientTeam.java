package com.softgroup.dsa.interview.leetcode.top150;
import java.util.*;

public class SmallestSufficientTeam {
    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int m = people.size();
        
        // Map each skill to a bit position
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }

        // Convert each person's skill set to a bitmask
        int[] skillMasks = new int[m];
        for (int i = 0; i < m; i++) {
            for (String skill : people.get(i)) {
                if (skillIndex.containsKey(skill)) {
                    skillMasks[i] |= 1 << skillIndex.get(skill);
                }
            }
        }

        // DP array to store the smallest team for each skill combination
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int personSkills = skillMasks[i];
            if (personSkills == 0) continue; // Skip people with no relevant skills

            for (int mask = (1 << n) - 1; mask >= 0; mask--) {
                if (dp[mask] == null) continue;

                int newMask = mask | personSkills;
                if (dp[newMask] == null || dp[newMask].size() > dp[mask].size() + 1) {
                    dp[newMask] = new ArrayList<>(dp[mask]);
                    dp[newMask].add(i);
                }
            }
        }

        List<Integer> result = dp[(1 << n) - 1];
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String[] req_skills = {"java", "nodejs", "reactjs"};
        List<List<String>> people = Arrays.asList(
                Arrays.asList("java"),
                Arrays.asList("nodejs"),
                Arrays.asList("nodejs", "reactjs")
        );

        int[] team = smallestSufficientTeam(req_skills, people);
        System.out.println("Smallest sufficient team: " + Arrays.toString(team));
    }
}
