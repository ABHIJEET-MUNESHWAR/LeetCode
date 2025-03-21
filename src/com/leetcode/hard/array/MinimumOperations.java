package com.leetcode.hard.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/07/24,
 * Time:    9:38 pm
 * 3229. Minimum Operations to Make Array Equal to Target
 * https://leetcode.com/problems/minimum-operations-to-make-array-equal-to-target/description/
 */
public class MinimumOperations {
    public static void main(String[] args) {
        MinimumOperations obj = new MinimumOperations();
        int[] nums = {3, 5, 1, 2};
        int[] target = {4, 6, 2, 4};
        System.out.println(obj.minimumOperations(nums, target));
    }

    private long minimumOperations(int[] nums, int[] target) {
        long result = 0;
        int n = nums.length;
        int prev = 0, curr = 0;
        for (int i = 0; i < n; i++) {
            curr = target[i] - nums[i];
            // Check for sign change
            if ((curr > 0 && prev < 0) || (curr < 0 && prev > 0)) {
                result += Math.abs(curr);
            } else if (Math.abs(prev) < Math.abs(curr)) {
                result += Math.abs(curr - prev);
            }
            prev = curr;
        }
        return result;
    }
}