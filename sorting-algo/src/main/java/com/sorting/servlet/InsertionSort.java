package com.sorting.servlet;

public class InsertionSort {
    public int[] sort(int[] array) {
        int[] sortedArray = array.clone();
        
        for (int i = 1; i < sortedArray.length; i++) {
            int key = sortedArray[i];
            int j = i - 1;
            
            while (j >= 0 && sortedArray[j] > key) {
                sortedArray[j + 1] = sortedArray[j];
                j = j - 1;
            }
            sortedArray[j + 1] = key;
        }
        
        return sortedArray;
    }
}