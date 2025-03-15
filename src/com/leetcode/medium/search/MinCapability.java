package com.leetcode.medium.search;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   15-03-2025
    Time:   10:24 pm
    2560. House Robber IV
    https://leetcode.com/problems/house-robber-iv/description/?envType=daily-question&envId=2025-03-15
*/

public class MinCapability {
    public static void main(String[] args) {
        MinCapability minCapability = new MinCapability();
        int[] nums = {2,3,5,9};
        int k=2;
        System.out.println(minCapability.minCapability(nums, k));
    }

    public boolean isPossibleToRob(int[] nums, int k, int mid) {
        int n = nums.length;
        int house = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= mid) {
                house++;
                i++;// skipping adjacent house
            }
        }
        return house >= k;// we managed to rob at least k houses
    }

    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossibleToRob(nums, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
