package com.leetcode.companies.meta.screening;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   25-03-2025
    Time:   05:49 pm
*/

public class LocalMinima {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 3, 1};
        LocalMinima localMinima = new LocalMinima();
        System.out.println(localMinima.localMinima(nums));
    }

    private int localMinima(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] < nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[n - 1];
    }
}
