package com.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/03/24,
 * Time:    7:47 am
 * https://leetcode.com/problems/binary-subarrays-with-sum/?envType=daily-question&envId=2024-03-14
 */
public class NumSubArraysWithSum {
  public static void main(String[] args) {
    NumSubArraysWithSum numSubArraysWithSum = new NumSubArraysWithSum();
    int[] nums = {1, 0, 1, 0, 1};
    int goal = 2;
    System.out.println(numSubArraysWithSum.numSubArraysWithSumBruteForce(nums, goal));
    System.out.println(numSubArraysWithSum.numSubArraysWithSumPrefixSumHashMap(nums, goal));
  }

  private int numSubArraysWithSumPrefixSumHashMap(int[] nums, int goal) {
    int count = 0;
    int size = nums.length;
    Map<Integer, Integer> prefixSumToFrequencyMap = new HashMap<>();
    int prefixSum = 0;
    prefixSumToFrequencyMap.put(0, 1);
    for (int i = 0; i < size; i++) {
      prefixSum += nums[i];
      if (prefixSumToFrequencyMap.containsKey(prefixSum - goal)) {
        count += prefixSumToFrequencyMap.get(prefixSum - goal);
      }
      prefixSumToFrequencyMap.put(
          prefixSum, prefixSumToFrequencyMap.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
  }

  private int numSubArraysWithSumBruteForce(int[] nums, int goal) {
    int count = 0;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int prefixSum = 0;
      for (int j = i; j < size; j++) {
        prefixSum += nums[j];
        if (prefixSum == goal) {
          count++;
        }
      }
    }
    return count;
  }
}