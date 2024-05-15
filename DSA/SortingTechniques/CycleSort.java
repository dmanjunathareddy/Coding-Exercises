package com.softgroup.dsa.sorting;
public class CycleSort {
    // Function to perform cycle sort
    public static void cycleSort(int[] arr) {
        int n = arr.length;
        
        // Traverse the array to find cycles to rotate
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            int item = arr[cycleStart];
            int pos = cycleStart;
            
            // Find the position where the item should go
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
            
            // If the item is already in the correct position, skip
            if (pos == cycleStart) {
                continue;
            }
            
            // Skip duplicate elements
            while (item == arr[pos]) {
                pos++;
            }
            
            // Swap the elements
            int temp = arr[pos];
            arr[pos] = item;
            item = temp;
            
            // Rotate the rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                
                // Find the position where the item should go
                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
                
                // Skip duplicate elements
                while (item == arr[pos]) {
                    pos++;
                }
                
                // Swap the elements
                temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
        }
    }
    
    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // Main method to test Cycle Sort
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 4, 9, 3, 7, 6};
        System.out.println("Original array:");
        printArray(arr);
        
        // Perform Cycle Sort
        cycleSort(arr);
        
        System.out.println("Array after Cycle Sort:");
        printArray(arr);
    }
}
