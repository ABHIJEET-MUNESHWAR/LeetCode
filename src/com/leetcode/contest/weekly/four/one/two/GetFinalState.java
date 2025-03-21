package com.leetcode.contest.weekly.four.one.two;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/08/24,
 * Time:    8:14 am
 * 3264. Final Array State After K Multiplication Operations I
 * https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/
 */
public class GetFinalState {
    public static void main(String[] args) {
        GetFinalState getFinalState = new GetFinalState();
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5, multiplier = 2;
        ArrayUtils.printArray(getFinalState.getFinalState(nums, k, multiplier));
    }

    private int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        while (k > 0) {
            int minIndex = findMin(nums, n);
            nums[minIndex] *= multiplier;
            k--;
        }
        return nums;
    }

    private int findMin(int[] nums, int n) {
        int min = nums[0];
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}