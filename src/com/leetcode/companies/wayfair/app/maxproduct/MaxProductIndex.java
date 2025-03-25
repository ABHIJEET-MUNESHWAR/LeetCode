package com.leetcode.companies.wayfair.app.maxproduct;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-03-2025
    Time:   10:31 am
    152. Maximum Product Subarray
    https://leetcode.com/problems/maximum-product-subarray/description/
*/

class Result {
    int maxProduct;
    int startIndex;
    int endIndex;

    public Result(int maxProduct, int startIndex, int endIndex) {
        this.maxProduct = maxProduct;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}

public class MaxProductIndex {
    public static void main(String[] args) {
        MaxProductIndex maxProduct = new MaxProductIndex();
        int[] nums = {2, 3, -2, 4};
        Result result = maxProduct.maxProduct(nums);
        System.out.println("Max Product: " + result.maxProduct);
        System.out.println("Start index: " + result.startIndex);
        System.out.println("End index: " + result.endIndex);
    }

    private Result maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1, suffix = 1;
        int startIndex = 0, endIndex = 0;
        int tempStartPrefix = 0, tempStartSuffix = n - 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
                tempStartPrefix = i;
            }
            if (suffix == 0) {
                suffix = 1;
                tempStartSuffix = n - i - 1;
            }
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            if (maxProduct < prefix) {
                maxProduct = prefix;
                startIndex = tempStartPrefix;
                endIndex = i;
            }
            if (maxProduct < suffix) {
                maxProduct = suffix;
                startIndex = tempStartSuffix;
                endIndex = n - i - 1;
            }
        }
        return new Result(maxProduct, startIndex, endIndex);
    }
}
