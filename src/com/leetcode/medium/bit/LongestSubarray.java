package com.leetcode.medium.bit;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   30-07-2025
    Time:   02:54 pm
    https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description/?envType=daily-question&envId=2025-07-30
    🟠 2419. Longest Subarray With Maximum Bitwise AND
*/

public class LongestSubarray {
    public static void main(String[] args) {
        LongestSubarray longestSubarray = new LongestSubarray();
        int[]           nums            = {1, 2, 3, 3, 2, 2};
        System.out.println(longestSubarray.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int maxLength = 0;
        int maxValue  = 0, streak = 0;
        for (int num : nums) {
            if (maxValue < num) {
                maxValue = num;
                streak = 0;
                maxLength = 0;
            }
            if (maxValue == num) {
                streak++;
            } else {
                streak = 0;
            }
            maxLength = Math.max(maxLength, streak);
        }
        return maxLength;
    }
}
