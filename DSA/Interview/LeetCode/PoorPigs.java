package com.softgroup.dsa.interview.leetcode;
public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int tests = minutesToTest / minutesToDie;
        return (int) Math.ceil(Math.log(buckets) / Math.log(tests + 1));
    }

    public static void main(String[] args) {
        PoorPigs solution = new PoorPigs();
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;
        System.out.println("The minimum number of pigs required is: " + solution.poorPigs(buckets, minutesToDie, minutesToTest));
    }
}
