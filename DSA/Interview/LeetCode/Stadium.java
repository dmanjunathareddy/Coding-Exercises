package com.softgroup.dsa.interview.leetcode;
import java.util.*;

class Stadium {
    private Map<String, Integer> entryLog;
    private Map<String, Integer> exitLog;
    private int currentCount;

    public Stadium() {
        entryLog = new HashMap<>();
        exitLog = new HashMap<>();
        currentCount = 0;
    }

    public void enter(String time) {
        entryLog.put(time, entryLog.getOrDefault(time, 0) + 1);
        currentCount++;
    }

    public void exit(String time) {
        if (currentCount > 0) {
            exitLog.put(time, exitLog.getOrDefault(time, 0) + 1);
            currentCount--;
        }
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void printLogs() {
        System.out.println("Entry Log:");
        for (String time : entryLog.keySet()) {
            System.out.println("Time: " + time + ", Count: " + entryLog.get(time));
        }
        System.out.println("Exit Log:");
        for (String time : exitLog.keySet()) {
            System.out.println("Time: " + time + ", Count: " + exitLog.get(time));
        }
        System.out.println("Current Count: " + currentCount);
    }

    public static void main(String[] args) {
        Stadium stadium = new Stadium();
        stadium.enter("10:00");
        stadium.enter("10:05");
        stadium.enter("10:10");
        stadium.exit("10:15");
        stadium.exit("10:20");
        stadium.enter("10:25");
        
        stadium.printLogs();
    }
}
