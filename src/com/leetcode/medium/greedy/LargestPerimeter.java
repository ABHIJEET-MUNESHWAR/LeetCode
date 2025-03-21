package com.leetcode.medium.greedy;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/07/24,
 * Time:    7:40 am
 */
public class LargestPerimeter {
    public static void main(String[] args) {
        LargestPerimeter largestPerimeter = new LargestPerimeter();
        int[] nums = {1, 12, 1, 2, 5, 50, 3};
        System.out.println(largestPerimeter.largestPerimeter(nums));
    }

    private long largestPerimeter(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return -1;
        }
        Arrays.sort(nums);
        long maxPerimeter = -1;
        long currentPerimeter = nums[0] + nums[1];
        for (int i = 2; i < n; i++) {
            if (currentPerimeter > nums[i]) {
                currentPerimeter += nums[i];
                maxPerimeter = Math.max(maxPerimeter, currentPerimeter);
            } else {
                currentPerimeter += nums[i];
            }
        }
        return maxPerimeter;
    }
}