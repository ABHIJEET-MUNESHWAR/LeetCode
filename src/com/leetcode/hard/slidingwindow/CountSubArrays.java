package com.leetcode.hard.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   28-04-2025
    Time:   09:17 pm
    2302. Count SubArrays With Score Less Than K
    https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/?envType=daily-question&envId=2025-04-28
*/

public class CountSubArrays {
    public static void main(String[] args) {
        CountSubArrays countSubArrays = new CountSubArrays();
        int nums[] = {2, 1, 4, 3, 5};
        int k = 10;
        System.out.println(countSubArrays.countSubArrays(nums, k));
    }

    private long countSubArrays(int[] nums, int k) {
        int n = nums.length;
        long result = 0, sum = 0;
        int left = 0, right = 0;
        while (right < n) {
            sum += nums[right];
            while (left <= right && (sum * (right - left + 1) >= k)) {
                sum -= nums[left];
                left++;
            }
            result += (right - left + 1);
            right++;
        }
        return result;
    }
}
