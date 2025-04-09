package com.leetcode.companies.meta.practice.array;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   09-04-2025
    Time:   12:21 pm
    Merge 3 sorted arrays (given with duplicates) by removing duplicates.
*/

import com.leetcode.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class SortedMerge {
    public static void main(String[] args) {
        SortedMerge sortedMerge = new SortedMerge();
        int[] arr1 = {1, 2, 2, 4};
        int[] arr2 = {2, 3, 5};
        int[] arr3 = {3, 4, 6};
        ArrayUtils.printArray(sortedMerge.sortedMerge(arr1, arr2, arr3));
    }

    private int[] sortedMerge(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();
        Integer lastAdded = null;
        int l1 = arr1.length;
        int l2 = arr2.length;
        int l3 = arr3.length;
        while (i < l1 || j < l2 || k < l3) {
            int val1 = i < l1 ? arr1[i] : Integer.MAX_VALUE;
            int val2 = j < l2 ? arr2[j] : Integer.MAX_VALUE;
            int val3 = k < l3 ? arr3[k] : Integer.MAX_VALUE;
            int min = Math.min(val1, Math.min(val2, val3));
            if (lastAdded == null || lastAdded != min) {
                result.add(min);
                lastAdded = min;
            }
            if (i < l1 && arr1[i] == min) {
                i++;
            }
            if (j < l2 && arr2[j] == min) {
                j++;
            }
            if (k < l3 && arr3[k] == min) {
                k++;
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
