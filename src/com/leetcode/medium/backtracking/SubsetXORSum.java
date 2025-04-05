package com.leetcode.medium.backtracking;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   05-04-2025
    Time:   10:40 pm
     🟠 1863. Sum of All Subset XOR Totals
    https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/?envType=daily-question&envId=2025-04-05
*/

import java.util.ArrayList;
import java.util.List;

public class SubsetXORSum {
    public static void main(String[] args) {
        SubsetXORSum subsetXORSum = new SubsetXORSum();
        int[] nums = {5, 1, 6};
        System.out.println(subsetXORSum.subsetXORSum(nums));
        System.out.println(subsetXORSum.subsetXORSumTwo(nums));
        System.out.println(subsetXORSum.subsetXORSumThree(nums));
    }

    private int subsetXORSumThree(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result |= nums[i];
        }
        return result << (n - 1);
    }

    private int subsetXORSumTwo(int[] nums) {
        return solve(nums, 0, 0);
    }

    public int solve(int[] nums, int index, int xor) {
        if (index >= nums.length) {
            return xor;
        }
        int take = solve(nums, index + 1, nums[index] ^ xor);
        int skip = solve(nums, index + 1, xor);
        return take + skip;
    }

    List<List<Integer>> subSets = new ArrayList<>();

    public void solve(int[] nums, int index, List<Integer> temp) {
        if (index >= nums.length) {
            subSets.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        solve(nums, index + 1, temp);
        temp.remove(temp.size() - 1);
        solve(nums, index + 1, temp);
    }

    public int subsetXORSum(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int result = 0;
        solve(nums, 0, temp);
        for (List<Integer> subSet : subSets) {
            int xor = 0;
            for (int set : subSet) {
                xor ^= set;
            }
            result += xor;
        }
        return result;
    }
}
