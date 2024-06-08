package com.softgroup.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesesII {
    public static void main(String[] args) {
        String s = "()[]{}";
        ValidParenthesesII solution = new ValidParenthesesII();
        System.out.println(solution.checkValidString(s)); // Output: true
    }

    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.pop() > starStack.pop()) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }
}