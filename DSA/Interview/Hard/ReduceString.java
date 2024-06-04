package com.softgroup.dsa.interview;
import java.util.Stack;

public class ReduceString {

    public static String reduceString(String s, int k) {
        if (k == 0) {
            return s;
        }

        Stack<Pair> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().character == c) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.character);
            }
        }

        return sb.toString();
    }

    private static class Pair {
        char character;
        int count;

        Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String s = "aaabbbccc";
        int k = 3;
        System.out.println(reduceString(s, k));  // Output: ""
        
        s = "pqqqrrrsss";
        k = 3;
        System.out.println(reduceString(s, k));  // Output: "pr"
        
        s = "deeedbbcccbdaa";
        k = 3;
        System.out.println(reduceString(s, k));  // Output: "aa"
    }
}
