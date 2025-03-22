package com.leetcode.companies.wayfair.maxproduct;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-03-2025
    Time:   10:31 am
    152. Maximum Product Subarray
    https://leetcode.com/problems/maximum-product-subarray/description/
*/

public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct.maxProduct(nums));
    }

    private int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1;
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }
}
