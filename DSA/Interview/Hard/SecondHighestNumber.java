package com.softgroup.dsa.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SecondHighestNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 2, 8, 8, 9, 4);
        Optional<Integer> secondHighestElement = numbers.stream()
                                                        .distinct()
                                                        .sorted((a, b) -> b - a)
                                                        .skip(1)
                                                        .findFirst();
        if (secondHighestElement.isPresent())
            System.out.println("Second Highest Element: " + secondHighestElement.get());
    }
}
