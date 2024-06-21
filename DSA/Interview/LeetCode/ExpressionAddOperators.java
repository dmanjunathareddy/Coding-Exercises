package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, "", num, target, 0, 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break; // Skip leading zero numbers
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                // First number in the expression, it cannot be prefixed by any operator
                backtrack(result, path + cur, num, target, i + 1, cur, cur);
            } else {
                backtrack(result, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                backtrack(result, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                backtrack(result, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(addOperators("123", 6));  // Output: ["1+2+3", "1*2*3"]
        System.out.println(addOperators("232", 8));  // Output: ["2*3+2", "2+3*2"]
        System.out.println(addOperators("105", 5));  // Output: ["1*0+5","10-5"]
        System.out.println(addOperators("00", 0));   // Output: ["0+0", "0-0", "0*0"]
        System.out.println(addOperators("3456237490", 9191)); // Output: []
    }
}
