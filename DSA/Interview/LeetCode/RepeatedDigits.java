package com.softgroup.dsa.interview.leetcode;
import java.util.HashSet;
import java.util.Set;

public class RepeatedDigits {

    public static boolean hasRepeatedDigits(int number) {
        Set<Character> digits = new HashSet<>();
        char[] numArray = String.valueOf(number).toCharArray();
        
        for (char digit : numArray) {
            if (!digits.add(digit)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {123, 112, 456, 789, 223344, 998877};

        System.out.println("Numbers with repeated digits:");
        for (int number : numbers) {
            if (hasRepeatedDigits(number)) {
                System.out.println(number);
            }
        }
    }
}
