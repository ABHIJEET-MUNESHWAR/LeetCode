package com.leetcode.medium.sorting;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   19-06-2025
    Time:   10:20 am
    🟠 2294. Partition Array Such That Maximum Difference Is K
    https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/?envType=daily-question&envId=2025-06-19
*/

import java.util.Arrays;

public class PartitionArray {
    public static void main(String[] args) {
        PartitionArray partitionArray = new PartitionArray();
        int[]          nums           = {3, 6, 1, 2, 5};
        int            k              = 2;
        System.out.println(partitionArray.partitionArray(nums, k));
    }

    public int partitionArray(int[] nums, int k) {
        int n     = nums.length;
        int count = 1;
        Arrays.sort(nums);
        int min = nums[0];
        for (int i = 0; i < n; i++) {
            if ((nums[i] - min) > k) {
                min = nums[i];
                count++;
            }
        }
        return count;
    }
}
