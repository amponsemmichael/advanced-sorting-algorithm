package com.sorting.servlet;

public class HeapSort {
    public int[] sort(int[] array) {
        int[] sortedArray = array.clone();
        int n = sortedArray.length;
        
        // Build the heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(sortedArray, n, i);
        }
        
        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            int temp = sortedArray[0];
            sortedArray[0] = sortedArray[i];
            sortedArray[i] = temp;
            
            // Call max heapify on the reduced heap
            heapify(sortedArray, i, 0);
        }
        
        return sortedArray;
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            
            heapify(array, n, largest);
        }
    }
}