package com.leetcode.companies.meta.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/07/24,
 * Time:    9:07 pm
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySum {
    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySum.subarraySum(nums, k));
    }

    private int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> diffToFreqMap = new HashMap<>();
        int result = 0;
        int prefixSum = 0;
        diffToFreqMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int diff = prefixSum - k;
            if (diffToFreqMap.containsKey(diff)) {
                result += diffToFreqMap.get(diff);
            }
            diffToFreqMap.put(prefixSum, diffToFreqMap.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}