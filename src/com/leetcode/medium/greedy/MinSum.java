package com.leetcode.medium.greedy;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-05-2025
    Time:   10:25 pm
    🟠 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros
    https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/?envType=daily-question&envId=2025-05-10
*/

public class MinSum {
    public static void main(String[] args) {
        MinSum minSum = new MinSum();
        int[]  nums1  = {3, 2, 0, 1, 0};
        int[]  nums2  = {6, 5, 0};
        System.out.println(minSum.minSum(nums1, nums2));
    }

    public long minSum(int[] nums1, int[] nums2) {
        long sum1      = 0, sum2 = 0;
        int  zeroInOne = 0, zeroInTwo = 0;
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                sum1++;
                zeroInOne++;
            }
        }
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                sum2++;
                zeroInTwo++;
            }
        }
        if (sum1 < sum2 && zeroInOne == 0) {
            return -1;
        }
        if (sum1 > sum2 && zeroInTwo == 0) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}
