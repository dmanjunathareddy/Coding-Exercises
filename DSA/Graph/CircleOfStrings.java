package com.softgroup.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class CircleOfStrings {
    public static void main(String[] args) {
        String[] strings = {"ABC", "DEF", "GHI"};

        List<List<String>> result = generateCircle(strings);

        // Displaying the result
        for (List<String> permutation : result) {
            System.out.println(permutation);
        }
    }

    public static List<List<String>> generateCircle(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        boolean[] used = new boolean[strings.length];
        generateCircleHelper(strings, current, result, used);
        return result;
    }

    private static void generateCircleHelper(String[] strings, List<String> current, List<List<String>> result, boolean[] used) {
        if (current.size() == strings.length) {
            // Ensure the first and last strings in the circle match
            String firstString = current.get(0);
            String lastString = current.get(current.size() - 1);
            if (firstString.charAt(0) == lastString.charAt(lastString.length() - 1)) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = 0; i < strings.length; i++) {
            if (!used[i]) {
                if (current.isEmpty() || current.get(current.size() - 1).charAt(current.get(current.size() - 1).length() - 1) == strings[i].charAt(0)) {
                    current.add(strings[i]);
                    used[i] = true;
                    generateCircleHelper(strings, current, result, used);
                    used[i] = false;
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
