package com.softgroup.dsa.interview.leetcode;
import java.util.TreeMap;

public class MyCalendarThree {
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);

        int activeEvents = 0, maxActiveEvents = 0;
        for (int eventCount : timeline.values()) {
            activeEvents += eventCount;
            maxActiveEvents = Math.max(maxActiveEvents, activeEvents);
        }

        return maxActiveEvents;
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendar = new MyCalendarThree();
        System.out.println(myCalendar.book(10, 20)); // 1
        System.out.println(myCalendar.book(50, 60)); // 1
        System.out.println(myCalendar.book(10, 40)); // 2
        System.out.println(myCalendar.book(5, 15)); // 3
        System.out.println(myCalendar.book(5, 10)); // 3
        System.out.println(myCalendar.book(25, 55)); // 3
    }
}
