package com.leetcode.easy.binarysearch;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   12-03-2025
    Time:   10:23 am
    2529. Maximum Count of Positive Integer and Negative Integer
    https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/?envType=daily-question&envId=2025-03-12
*/

public class MaximumCount {
    public static void main(String[] args) {
        MaximumCount maximumCount = new MaximumCount();
        int[] nums = {-2, -1, -1, 0, 0, 0, 1, 2, 3};
        System.out.println(maximumCount.getMaxCount(nums));
    }

    private int getMaxCount(int[] nums) {
        int n = nums.length;
        int positives = lowerBound(nums, 1); // >=1
        int negatives = lowerBound(nums, 0); // >=0
        return Math.max(n - positives, negatives);
    }

    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int result = n;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}
