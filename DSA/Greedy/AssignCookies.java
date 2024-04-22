package com.softgroup.dsa.greedy;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);
        
        int childIndex = 0;
        int cookieIndex = 0;
        int contentChildren = 0;
        
        while (childIndex < greed.length && cookieIndex < cookies.length) {
            if (greed[childIndex] <= cookies[cookieIndex]) {
                contentChildren++;
                childIndex++;
            }
            cookieIndex++;
        }
        
        return contentChildren;
    }
    
    public static void main(String[] args) {
        int[] greed = {1, 2, 3};
        int[] cookies = {1, 1};
        System.out.println("Maximum number of content children: " + findContentChildren(greed, cookies));
    }
}
