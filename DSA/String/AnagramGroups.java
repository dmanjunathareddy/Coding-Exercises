package com.softgroup.dsa.string;

import java.util.*;

public class AnagramGroups {

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Hash map to store anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        // Iterate through each string in the array
        for (String str : strs) {
            // Convert the string to a character array
            char[] charArray = str.toCharArray();
            // Sort the character array
            Arrays.sort(charArray);
            // Convert the sorted character array back to a string
            String sortedStr = new String(charArray);
            
            // Use the sorted string as the key in the hash map
            if (!anagramMap.containsKey(sortedStr)) {
                // If the key doesn't exist, create a new list for the value
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            
            // Add the original string to the list for the sorted string key
            anagramMap.get(sortedStr).add(str);
        }
        
        // Return the values of the hash map as a list of lists
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        // Test the function with some examples
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println("Anagram groups: " + result);
        // Output: [[eat, tea, ate], [tan, nat], [bat]]
    }
}
