package com.softgroup.dsa.array;

public class LongestNameFinder {
    
    public static String findLongestName(String[] names) {
        if (names == null || names.length == 0) {
            return null; // No names provided
        }
        
        String longestName = names[0]; // Initialize with the first name
        
        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > longestName.length()) {
                longestName = names[i];
            }
        }
        
        return longestName;
    }
    
    public static void main(String[] args) {
        String[] names = {"Manjunatha", "reddy", "Ruthivk", "Aadhya", "Aparna"};
        String longestName = findLongestName(names);
        
        if (longestName != null) {
            System.out.println("The longest name is: " + longestName);
        } else {
            System.out.println("No names provided");
        }
    }
}
