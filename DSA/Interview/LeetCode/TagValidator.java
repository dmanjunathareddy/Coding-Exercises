package com.softgroup.dsa.interview.leetcode;
import java.util.Stack;

public class TagValidator {
    
    public static void main(String[] args) {
        String code = "<DIV>This is the first line <A> This is valid </A></DIV>";
        boolean isValid = isValidTagStructure(code);
        System.out.println("Is the code valid? " + isValid);
    }

    public static boolean isValidTagStructure(String code) {
        Stack<String> stack = new Stack<>();
        int n = code.length();
        int i = 0;

        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i + 1 < n && code.charAt(i + 1) == '/') {
                    // It's a closing tag
                    int j = code.indexOf('>', i);
                    if (j < 0) return false;
                    String tagName = code.substring(i + 2, j);
                    if (stack.isEmpty() || !stack.pop().equals(tagName)) return false;
                    i = j + 1;
                    if (stack.isEmpty() && i < n) return false; // additional content after root tag is closed
                } else {
                    // It's an opening tag
                    int j = code.indexOf('>', i);
                    if (j < 0) return false;
                    String tagName = code.substring(i + 1, j);
                    if (!isValidTagName(tagName)) return false;
                    stack.push(tagName);
                    i = j + 1;
                }
            } else {
                // It's a character within a tag
                if (stack.isEmpty()) return false;
                i++;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isValidTagName(String tagName) {
        if (tagName.length() < 1 || tagName.length() > 9) return false;
        for (char c : tagName.toCharArray()) {
            if (!Character.isUpperCase(c)) return false;
        }
        return true;
    }
}
