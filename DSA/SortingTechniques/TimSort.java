package com.softgroup.dsa.sorting;
import java.util.Arrays;

public class TimSort {

    // Minimum size of a run
    private static final int RUN = 32;

    // This function sorts array from left index to right index
    // which is of size at most RUN
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Merge function merges the sorted runs
    private static void merge(int[] arr, int l, int m, int r) {
        // Original array is broken in two parts
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++) {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++) {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // After comparing, we merge those two sorted arrays
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left, if any
        while (i < len1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining element of right, if any
        while (j < len2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    // Iterative Timsort function to sort the array[0...n-1]
    public static void timSort(int[] arr, int n) {
        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + RUN - 1), (n - 1)));
        }

        // Start merging from size RUN (or 32). It will merge
        // to form size 64, then 128, 256 and so on ....
        for (int size = RUN; size < n; size = 2 * size) {
            // Pick starting point of left sub array. We are going to merge
            // arr[left..left+size-1] and arr[left+size, left+2*size-1]
            // After every merge, we increase left by 2*size
            for (int left = 0; left < n; left += 2 * size) {
                // Find ending point of left sub array
                // mid+1 is starting point of right sub array
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                // Merge sub array arr[left.....mid] & arr[mid+1....right]
                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    // Driver program to test the sorting algorithm
    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19, 8, 15, 34, 2, 45, 90, 11, 25, 1, 78, 99, 44, 12};
        System.out.println("Given Array is");
        System.out.println(Arrays.toString(arr));

        timSort(arr, arr.length);

        System.out.println("After Sorting Array is");
        System.out.println(Arrays.toString(arr));
    }
}
