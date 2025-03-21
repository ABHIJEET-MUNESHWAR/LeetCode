package com.leetcode.medium.greedy;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/07/24,
 * Time:    11:28 pm
 * 1846. Maximum Element After Decreasing and Rearranging
 * https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/description/
 */
public class MaximumElementAfterDecrementingAndRearranging {
    public static void main(String[] args) {
        MaximumElementAfterDecrementingAndRearranging obj = new MaximumElementAfterDecrementingAndRearranging();
        int[] arr = {2, 2, 1, 2, 1};
        System.out.println(obj.maximumElementAfterDecrementingAndRearranging(arr));
    }

    private int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int max = 1;
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i - 1] - arr[i]);
            if (diff > 1) {
                arr[i] = arr[i - 1] + 1;
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}