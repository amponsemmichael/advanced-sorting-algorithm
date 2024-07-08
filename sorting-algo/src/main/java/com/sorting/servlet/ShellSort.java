package com.sorting.servlet;

public class ShellSort {
    
    // Method to sort the given array using Shell Sort and return the result as an array
    public int[] sort(int[] array) {
        int n = array.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                // Save array[i] in temp and make a hole at position i
                int temp = array[i];

                // Shift earlier gap-sorted elements up until the correct location for array[i] is found
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // Put temp (the original array[i]) in its correct location
                array[j] = temp;
            }
        }

        // Return the sorted array
        return array;
    }
}
