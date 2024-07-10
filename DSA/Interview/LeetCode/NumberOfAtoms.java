package com.softgroup.dsa.interview.leetcode;
import java.util.*;
public class NumberOfAtoms {

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> countMap = parseFormula(formula, 0, formula.length());
        StringBuilder result = new StringBuilder();
        for (String atom : countMap.keySet()) {
            result.append(atom);
            int count = countMap.get(atom);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }

    private TreeMap<String, Integer> parseFormula(String formula, int start, int end) {
        TreeMap<String, Integer> countMap = new TreeMap<>();
        int i = start;
        while (i < end) {
            if (formula.charAt(i) == '(') {
                int j = findClosingBracket(formula, i);
                TreeMap<String, Integer> subMap = parseFormula(formula, i + 1, j);
                i = j + 1;
                int multiplier = parseNumber(formula, i);
                for (String atom : subMap.keySet()) {
                    countMap.put(atom, countMap.getOrDefault(atom, 0) + subMap.get(atom) * multiplier);
                }
                i += Integer.toString(multiplier).length();
            } else {
                int j = i + 1;
                while (j < end && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String atom = formula.substring(i, j);
                i = j;
                int count = parseNumber(formula, i);
                countMap.put(atom, countMap.getOrDefault(atom, 0) + count);
                i += Integer.toString(count).length();
            }
        }
        return countMap;
    }

    private int findClosingBracket(String formula, int start) {
        int count = 0;
        for (int i = start; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                count++;
            } else if (formula.charAt(i) == ')') {
                count--;
                if (count == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int parseNumber(String formula, int i) {
        if (i < formula.length() && Character.isDigit(formula.charAt(i))) {
            int j = i;
            while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                j++;
            }
            return Integer.parseInt(formula.substring(i, j));
        }
        return 1;
    }

    public static void main(String[] args) {
        NumberOfAtoms solver = new NumberOfAtoms();
        System.out.println(solver.countOfAtoms("H2O")); // H2O
        System.out.println(solver.countOfAtoms("Mg(OH)2")); // H2MgO2
        System.out.println(solver.countOfAtoms("K4(ON(SO3)2)2")); // K4N2O14S4
    }
}
