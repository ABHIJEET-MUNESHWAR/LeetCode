package com.leetcode.medium.search;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   13-03-2025
    Time:   09:49 pm
    3356. Zero Array Transformation II
    https://leetcode.com/problems/zero-array-transformation-ii/description/?envType=daily-question&envId=2025-03-13
*/

public class MinZeroArray {
    public static void main(String[] args) {
        MinZeroArray minZeroArray = new MinZeroArray();
        int[] nums = {2, 0, 2};
        int[][] queries = {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}};
        System.out.println(minZeroArray.minZeroArray(nums, queries));
    }

    public boolean checkWithDifferenceArray(int[] nums, int[][] queries, int mid) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i <= mid; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int value = queries[i][2];
            diff[start] += value;
            if (end < n - 1) {
                diff[end + 1] -= value;
            }
        }
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];
            diff[i] = prefixSum;
            if ((nums[i] - diff[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        boolean isAllZero = true;
        for (int num : nums) {
            if (num != 0) {
                isAllZero = false;
                break;
            }
        }
        if (isAllZero) {
            return 0;
        }
        int result = -1;
        int n = nums.length;
        int q = queries.length;
        int left = 0;
        int right = q - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (checkWithDifferenceArray(nums, queries, mid)) {
                result = mid + 1;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
