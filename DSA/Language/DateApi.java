package com.softgroup.language.java;

import java.time.LocalDate;

public class DateApi {
    public static void main(String[] args) {
        // Get the current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        // Create a specific date
        LocalDate specificDate = LocalDate.of(2024, 4, 27);
        System.out.println("Specific date: " + specificDate);
    }
}
