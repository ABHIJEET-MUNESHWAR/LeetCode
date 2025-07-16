package com.leetcode.medium.array;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   16-07-2025
    Time:   08:32 pm
    🟠 3201. Find the Maximum Length of Valid Subsequence I
    https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description/?envType=daily-question&envId=2025-07-16
*/

public class MaximumLength {
    public static void main(String[] args) {
        MaximumLength maximumLength = new MaximumLength();
        int[]         nums          = {1, 2, 3, 4};
        System.out.println(maximumLength.maximumLength(nums));
    }

    public int maximumLength(int[] nums) {
        int evenLength = 0, oddLength = 0;
        int n          = nums.length;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenLength++;
            } else {
                oddLength++;
            }
        }
        int altLength  = 1; // At least 1 length
        int prevParity = nums[0] % 2;
        for (int i = 1; i < n; i++) {
            int currParity = nums[i] % 2;
            if (currParity != prevParity) {
                altLength++;
                prevParity = currParity;
            }
        }
        return Math.max(altLength, Math.max(evenLength, oddLength));
    }
}
