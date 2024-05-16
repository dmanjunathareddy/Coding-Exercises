package com.softgroup.dsa.sorting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StrandSort {

    // Method to sort the list using Strand Sort
    public static List<Integer> strandSort(List<Integer> inputList) {
        // List to hold the final sorted result
        List<Integer> sortedList = new LinkedList<>();

        // Continue sorting until the input list is empty
        while (!inputList.isEmpty()) {
            // Extract a sorted strand from the input list
            List<Integer> strand = extractStrand(inputList);

            // Merge the extracted strand with the sorted list
            sortedList = merge(sortedList, strand);
        }

        return sortedList;
    }

    // Method to extract a strand from the input list
    private static List<Integer> extractStrand(List<Integer> inputList) {
        List<Integer> strand = new ArrayList<>();

        // Start by taking the first element of the input list
        strand.add(inputList.remove(0));

        // Iterate through the input list to extract an increasing subsequence
        for (int i = 0; i < inputList.size(); ) {
            if (inputList.get(i) > strand.get(strand.size() - 1)) {
                strand.add(inputList.remove(i));
            } else {
                i++;
            }
        }

        return strand;
    }

    // Method to merge two sorted lists
    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new LinkedList<>();
        int i = 0, j = 0;

        // Merge the lists by comparing elements one by one
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }

        // Add remaining elements from list1
        while (i < list1.size()) {
            result.add(list1.get(i++));
        }

        // Add remaining elements from list2
        while (j < list2.size()) {
            result.add(list2.get(j++));
        }

        return result;
    }

    // Main method for testing the Strand Sort implementation
    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(10);
        inputList.add(5);
        inputList.add(30);
        inputList.add(15);
        inputList.add(20);
        inputList.add(35);
        inputList.add(40);

        System.out.println("Original list: " + inputList);
        List<Integer> sortedList = strandSort(inputList);
        System.out.println("Sorted list: " + sortedList);
    }
}
