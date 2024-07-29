package com.softgroup.dsa.interview.leetcode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContiguousDates {
    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2023, 7, 1));
        dates.add(LocalDate.of(2023, 7, 2));
        dates.add(LocalDate.of(2023, 7, 4));
        dates.add(LocalDate.of(2023, 7, 5));
        dates.add(LocalDate.of(2023, 7, 6));

        reportContiguousDates(dates);
    }

    public static void reportContiguousDates(List<LocalDate> dates) {
        if (dates.isEmpty()) return;

        LocalDate start = dates.get(0);
        LocalDate end = start;

        for (int i = 1; i < dates.size(); i++) {
            LocalDate current = dates.get(i);
            if (current.equals(end.plusDays(1))) {
                end = current;
            } else {
                System.out.println("From: " + start + " To: " + end);
                start = current;
                end = current;
            }
        }
        System.out.println("From: " + start + " To: " + end);
    }
}
