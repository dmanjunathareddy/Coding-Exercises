package com.softgroup.dsa.interview.leetcode;
public class SelfCrossing {
    public boolean isSelfCrossing(int[] distance) {
        if (distance == null || distance.length < 4) {
            return false;
        }

        for (int i = 3; i < distance.length; i++) {
            // Case 1: Fourth line crosses the first line
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            // Case 2: Fifth line meets the first line
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            }
            // Case 3: Sixth line crosses the first line
            if (i >= 5 && distance[i - 2] >= distance[i - 4] && distance[i] + distance[i - 4] >= distance[i - 2] &&
                distance[i - 1] <= distance[i - 3] && distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        SelfCrossing selfCrossing = new SelfCrossing();
        int[] distance1 = {2, 1, 1, 2};
        int[] distance2 = {1, 2, 3, 4};
        int[] distance3 = {1, 1, 1, 1};

        System.out.println(selfCrossing.isSelfCrossing(distance1)); // Output: true
        System.out.println(selfCrossing.isSelfCrossing(distance2)); // Output: false
        System.out.println(selfCrossing.isSelfCrossing(distance3)); // Output: true
    }
}
