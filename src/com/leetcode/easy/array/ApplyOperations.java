package com.leetcode.easy.array;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   01-03-2025
    Time:   02:13 pm
    2460. Apply Operations to an Array
    https://leetcode.com/problems/apply-operations-to-an-array/description/?envType=daily-question&envId=2025-03-01
*/

import com.leetcode.utils.ArrayUtils;

public class ApplyOperations {
    public static void main(String[] args) {
        ApplyOperations applyOperations = new ApplyOperations();
        int[] nums = {1, 2, 2, 1, 1, 0};
        ArrayUtils.printArray(applyOperations.applyOperations(nums));
    }

    private int[] applyOperations(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                if (i != j) {
                    swap(nums, i, j);
                }
                j++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
