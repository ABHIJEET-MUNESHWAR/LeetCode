package com.leetcode.companies.meta.practice.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/05/24,
 * Time:    5:07 pm
 * 1004. Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class LongestOnes {
    public static void main(String[] args) {
        LongestOnes longestOnes = new LongestOnes();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes.longestOnesSlidingWindow(nums, k));
    }

    private int longestOnesSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, maxLength = 0, zeroCount = 0;
        while (right < n) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}