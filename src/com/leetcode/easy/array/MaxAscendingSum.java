package com.leetcode.easy.array;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   04-02-2025
    Time:   10:12 am
    https://leetcode.com/problems/maximum-ascending-subarray-sum/description/?envType=daily-question&envId=2025-02-04
*/

public class MaxAscendingSum {
    public static void main(String[] args) {
        MaxAscendingSum maxAscendingSum = new MaxAscendingSum();
        int[] nums = {10, 20, 30, 5, 10, 50};
        System.out.println(maxAscendingSum.maxAscendingSum(nums));
    }

    private int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
