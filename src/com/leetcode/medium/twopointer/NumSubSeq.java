package com.leetcode.medium.twopointer;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/07/24,
 * Time:    10:44 am
 * 1498. Number of Subsequences That Satisfy the Given Sum Condition
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
 */
public class NumSubSeq {
    public static void main(String[] args) {
        NumSubSeq numSubSeq = new NumSubSeq();
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        System.out.println(numSubSeq.numSubSeq(nums, target));
    }

    private int numSubSeq(int[] nums, int target) {
        int count = 0;
        int mod = 1000000007;
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                int diff = right - left;
                count = (count % mod) + power[diff] % mod;
                left++;
            } else {
                right--;
            }
        }
        return count % mod;
    }
}