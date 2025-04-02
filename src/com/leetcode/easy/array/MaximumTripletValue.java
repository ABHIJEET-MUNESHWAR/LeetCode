package com.leetcode.easy.array;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   02-04-2025
    Time:   12:25 pm
    2873. Maximum Value of an Ordered Triplet I
    https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/?envType=daily-question&envId=2025-04-02
*/

public class MaximumTripletValue {
    public static void main(String[] args) {
        MaximumTripletValue maximumTripletValue = new MaximumTripletValue();
        int[] nums = {12, 6, 1, 2, 7};
        System.out.println(maximumTripletValue.maximumTripletValue(nums));
    }

    private long maximumTripletValue(int[] nums) {
        long maxI = 0, maxDiff = 0, maxResult = 0;
        for (int num : nums) {
            maxResult = Math.max(maxResult, num * maxDiff);
            maxDiff = Math.max(maxDiff, maxI - num);
            maxI = Math.max(maxI, num);
        }
        return maxResult;
    }
}
