package com.softgroup.language.java;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationsExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // forEach(Consumer): Print each number
        numbers.stream().forEach(System.out::println);

        // collect(Collector): Convert to a List
        List<Integer> squaredNumbers = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println("Squared numbers: " + squaredNumbers);

        // toArray(): Convert to an array
        Integer[] numbersArray = numbers.stream().toArray(Integer[]::new);
        System.out.println("Numbers as array: " + Arrays.toString(numbersArray));

        // reduce(BinaryOperator): Sum of all elements
        Optional<Integer> sum = numbers.stream().reduce((x, y) -> x + y);
        System.out.println("Sum of numbers: " + sum.orElse(0));

        // min(Comparator): Find minimum number
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("Minimum number: " + min.orElse(0));

        // max(Comparator): Find maximum number
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Maximum number: " + max.orElse(0));

        // count(): Count the number of elements
        long count = numbers.stream().count();
        System.out.println("Number of elements: " + count);

        // anyMatch(Predicate): Check if any number is even
        boolean anyEven = numbers.stream().anyMatch(x -> x % 2 == 0);
        System.out.println("Any number is even: " + anyEven);

        // allMatch(Predicate): Check if all numbers are less than 10
        boolean allLessThanTen = numbers.stream().allMatch(x -> x < 10);
        System.out.println("All numbers are less than 10: " + allLessThanTen);

        // noneMatch(Predicate): Check if no number is negative
        boolean noneNegative = numbers.stream().noneMatch(x -> x < 0);
        System.out.println("No negative numbers: " + noneNegative);

        // findFirst(): Find the first element
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println("First number: " + first.orElse(0));

        // findAny(): Find any element
        Optional<Integer> any = numbers.stream().findAny();
        System.out.println("Any number: " + any.orElse(0));
    }
}
