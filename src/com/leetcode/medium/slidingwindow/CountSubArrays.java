package com.leetcode.medium.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   29-04-2025
    Time:   10:31 am
    🟠 2962. Count SubArrays Where Max Element Appears at Least K Times
    Link: https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
*/

public class CountSubArrays {
    public static void main(String[] args) {
        CountSubArrays countSubArrays = new CountSubArrays();
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        System.out.println(countSubArrays.countSubArrays(nums, k)); // Output: 6
    }

    private long countSubArrays(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        int left = 0, right = 0, maxFreq = 0;
        while (right < n) {
            if (nums[right] == max) {
                maxFreq++;
            }
            while (maxFreq >= k) {
                result += n - right;
                if (nums[left] == max) {
                    maxFreq--;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
