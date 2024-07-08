package com.sorting.servlet;

public class RadixSort {
    
    // Method to sort the given array using Radix Sort and return the result as an array
    public int[] sort(int[] array) {
        // Clone the input array to avoid modifying the original array
        int[] input = array.clone(); 
        
        // Get the maximum element in the array to determine the number of digits
        int max = getMax(array);
        
        // Perform counting sort for every digit (1, 10, 100, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
        
        // Return the sorted array
        return array;
    }

    // Method to get the maximum value in the array
    private int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Method to perform counting sort on the array based on the digit represented by exp
    private void countSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // count array

        // Initialize count array to 0
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Store the count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to array[], so that array now contains sorted numbers
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
}
