package com.softgroup.dsa.array;
public class StringRotation {

    // Method to check if s2 is a rotation of s1
    public static boolean isRotation(String s1, String s2) {
        // Check if s1 and s2 are of the same length and are not empty
        if (s1.length() == s2.length() && s1.length() > 0) {
            // Concatenate s1 with itself
            String concatenated = s1 + s1;
            // Check if s2 is a substring of the concatenated string
            return concatenated.contains(s2);
        }
        return false;
    }

    // Main method to test the isRotation method
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        if (isRotation(s1, s2)) {
            System.out.println(s2 + " is a rotation of " + s1);
        } else {
            System.out.println(s2 + " is not a rotation of " + s1);
        }
    }
}
