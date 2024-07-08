package com.sorting.servlet;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public int[] sort(int[] array) {
        int[] sortedArray = array.clone();
        
        // Find the minimum and maximum values
        int max = sortedArray[0], min = sortedArray[0];
        for (int i : sortedArray) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        
        // Calculate the number of buckets
        int bucketCount = (max - min) / sortedArray.length + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        
        // Distribute input array values into buckets
        for (int i : sortedArray) {
            buckets.get((i - min) / sortedArray.length).add(i);
        }
        
        // Sort each bucket and collect the sorted values
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int i : bucket) {
                sortedArray[index++] = i;
            }
        }
        
        return sortedArray;
    }
}