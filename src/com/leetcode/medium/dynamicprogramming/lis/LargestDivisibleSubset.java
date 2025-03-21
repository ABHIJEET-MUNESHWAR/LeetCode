package com.leetcode.medium.dynamicprogramming.lis;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/06/24,
 * Time:    4:10 pm
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/description/
 */
public class LargestDivisibleSubset {
  public static void main(String[] args) {
    LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
    int[] nums = {1, 2, 3};
    ListUtils.printList(largestDivisibleSubset.largestDivisibleSubsetRecursion(nums));
    ListUtils.printList(largestDivisibleSubset.largestDivisibleBottomUp(nums));
  }

  private List<Integer> largestDivisibleBottomUp(int[] nums) {
    Arrays.sort(nums);
    int size = nums.length;
    int[] dp = new int[size];
    int[] previousIndexArray = new int[size];
    for (int i = 0; i < size; i++) {
      previousIndexArray[i] = -1;
      dp[i] = 1;
    }
    int lastChosenIndex = 0;
    int maxLength = 1;
    for (int i = 1; i < size; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          if (dp[i] < dp[j] + 1) {
            dp[i] = dp[j] + 1;
            previousIndexArray[i] = j;
          }
          if (maxLength < dp[i]) {
            maxLength = dp[i];
            lastChosenIndex = i;
          }
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    while (lastChosenIndex != -1) {
      result.add(nums[lastChosenIndex]);
      lastChosenIndex = previousIndexArray[lastChosenIndex];
    }
    return result;
  }

  private List<Integer> largestDivisibleSubsetRecursion(int[] nums) {
    Arrays.sort(nums);
    List<Integer> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    solveRecursion(nums, result, temp, -1, 0);
    return result;
  }

  private void solveRecursion(int[] nums, List<Integer> result, List<Integer> temp, int previous, int current) {
    if (current >= nums.length) {
      if (temp.size() > result.size()) {
        result.clear();
        result.addAll(temp);
      }
      return;
    }
    if ((previous == -1) || (nums[current] % previous == 0)) {
      temp.add(nums[current]);          // Take
      solveRecursion(nums, result, temp, nums[current], current + 1);
      temp.remove(temp.size() - 1); // Skip
    }
    solveRecursion(nums, result, temp, previous, current + 1);
  }
}