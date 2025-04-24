package com.leetcode.companies.meta.practice.binarysearch;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   18-04-2025
    Time:   04:09 pm
    1539. Kth Missing Positive Number
    https://leetcode.com/problems/kth-missing-positive-number/description/
*/

public class FindKthPositive {
    public static void main(String[] args) {
        FindKthPositive findKthPositive = new FindKthPositive();
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive.findKthPositive(arr, k));
    }

    private int findKthPositive(int[] arr, int k) {
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((arr[mid] - (mid + 1)) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}
