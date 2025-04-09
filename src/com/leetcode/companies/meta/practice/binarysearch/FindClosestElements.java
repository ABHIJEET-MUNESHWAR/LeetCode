package com.leetcode.companies.meta.practice.binarysearch;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   09-04-2025
    Time:   05:22 pm
    658. Find K Closest Elements
    https://leetcode.com/problems/find-k-closest-elements/description/
*/

import com.leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {
    public static void main(String[] args) {
        FindClosestElements findClosestElements = new FindClosestElements();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        ListUtils.printList(findClosestElements.findClosestElements(arr, k, x));
    }

    private List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0, right = n - k;
        List<Integer> result = new ArrayList<>();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
