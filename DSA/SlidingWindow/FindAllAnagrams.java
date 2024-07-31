package com.softgroup.dsa.slidingwindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length())
            return result;
        
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0, count = p.length();
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (charCountMap.containsKey(rightChar)) {
                if (charCountMap.get(rightChar) > 0) {
                    count--;
                }
                charCountMap.put(rightChar, charCountMap.get(rightChar) - 1);
                right++;
            } else {
                while (left < right) {
                    char leftChar = s.charAt(left);
                    if (charCountMap.containsKey(leftChar)) {
                        if (charCountMap.get(leftChar) >= 0) {
                            count++;
                        }
                        charCountMap.put(leftChar, charCountMap.get(leftChar) + 1);
                    }
                    left++;
                }
                right++;
                left = right;
            }
            
            if (count == 0) {
                result.add(left);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagramIndices = findAnagrams(s, p);
        System.out.println("Indices of anagrams of \"" + p + "\" in \"" + s + "\": " + anagramIndices);
    }
}

