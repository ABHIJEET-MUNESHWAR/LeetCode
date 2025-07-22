package com.leetcode.medium.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-07-2025
    Time:   09:04 pm
    🟠 1695. Maximum Erasure Value
    https://leetcode.com/problems/maximum-erasure-value/description/?envType=daily-question&envId=2025-07-22
*/

import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarray {
    public static void main(String[] args) {
        MaximumUniqueSubarray maximumUniqueSubarray = new MaximumUniqueSubarray();
        int[]nums = {4,2,4,5,6};
        System.out.println(maximumUniqueSubarray.maximumUniqueSubarray(nums));
    }

    public int maximumUniqueSubarray(int[] nums) {
        int          n        = nums.length;
        int          maxValue = 0;
        int          left = 0, right = 0, sum = 0;
        Set<Integer> set  = new HashSet<>();
        while (right < n) {
            if (!set.contains(nums[right])) {
                sum += nums[right];
                maxValue = Math.max(maxValue, sum);
                set.add(nums[right++]);
            } else {
                sum -= nums[left];
                set.remove(nums[left++]);
            }
        }
        return maxValue;
    }
}
