package com.leetcode.medium.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/05/24,
 * Time:    4:09 pm
 * 2597. The Number of Beautiful Subsets
 */
public class TheNumberOfBeautifulSubsets {
  public static void main(String[] args) {
    TheNumberOfBeautifulSubsets theNumberOfBeautifulSubsets = new TheNumberOfBeautifulSubsets();
    int[] nums = {2, 4, 6};
    int k = 2;
    System.out.println(theNumberOfBeautifulSubsets.beautifulSubsets(nums, k));
  }

  int result = 0;
  int K = 0;

  private int beautifulSubsets(int[] nums, int k) {
    K = k;
    Map<Integer, Integer> frequency = new HashMap<>();
    solve(nums, 0, frequency);
    return result - 1;
  }

  private void solve(int[] nums, int index, Map<Integer, Integer> frequency) {
    if (index >= nums.length) {
      result++;
      return;
    }
    // Skip
    solve(nums, index + 1, frequency);
    // Take
    if (!frequency.containsKey(nums[index] - K) && !frequency.containsKey(K + nums[index])) {
      frequency.put(nums[index], frequency.getOrDefault(nums[index], 0) + 1); // Do
      solve(nums, index + 1, frequency); // Backtracking
      frequency.put(nums[index], frequency.getOrDefault(nums[index], 0) - 1); // Undo
      if (frequency.get(nums[index]) == 0) {
        frequency.remove(nums[index]);
      }
    }
  }
}