package com.leetcode.easy.array;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   06-05-2025
    Time:   10:10 am
    🟢 1920. Build Array from Permutation
    https://leetcode.com/problems/build-array-from-permutation/description/?envType=daily-question&envId=2025-05-06
*/

import com.leetcode.utils.ArrayUtils;

public class BuildArray {
    public static void main(String[] args) {
        BuildArray buildArray = new BuildArray();
        int[] nums = {0, 2, 1, 5, 3, 4};
        ArrayUtils.printArray(buildArray.buildArray(nums));
    }

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }
        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }
        return nums;
    }
}
