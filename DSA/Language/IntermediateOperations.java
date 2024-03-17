package com.softgroup.language.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperations {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "grape", "apple");

        // Filter words starting with 'a'
        List<String> filteredWords = words.stream()
                .filter(word -> word.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println("Filtered words: " + filteredWords);

        // Map each word to its length
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Word lengths: " + wordLengths);

        // FlatMap each word to its characters
        List<Character> characters = words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Characters: " + characters);

        // Remove duplicates
        List<String> uniqueWords = words.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique words: " + uniqueWords);

        // Sort words alphabetically
        List<String> sortedWords = words.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted words: " + sortedWords);

        // Limit the number of words to 3
        List<String> limitedWords = words.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Limited words: " + limitedWords);

        // Skip the first 2 words
        List<String> skippedWords = words.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Skipped words: " + skippedWords);

        // Peek into each word and print its length
        List<String> peekedWords = words.stream()
                .peek(word -> System.out.println("Word: " + word + ", Length: " + word.length()))
                .collect(Collectors.toList());
        System.out.println("Peeked words: " + peekedWords);
    }
}
