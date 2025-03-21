package com.leetcode.medium.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/07/24,
 * Time:    11:44 pm
 * 2870. Minimum Number of Operations to Make Array Empty
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/
 */
public class MinOperations {
    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        int[] nums = {2, 3, 3, 2, 2, 4, 2, 3, 4};
        System.out.println(minOperations.minOperations(nums));
    }

    private int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> intToFreqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            intToFreqMap.put(nums[i], intToFreqMap.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : intToFreqMap.entrySet()) {
            int freq = entry.getValue();
            if (freq == 1) {
                return -1;
            }
            result += Math.ceil((double) freq / 3);
        }
        return result;
    }
}