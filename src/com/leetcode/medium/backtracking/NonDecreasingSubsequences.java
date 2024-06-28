package com.leetcode.medium.backtracking;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/06/24,
 * Time:    8:32 pm
 * 491. Non-decreasing Subsequences
 * https://leetcode.com/problems/non-decreasing-subsequences/description/
 */
public class NonDecreasingSubsequences {
  public static void main(String[] args) {
    NonDecreasingSubsequences nonDecreasingSubsequences = new NonDecreasingSubsequences();
    int[] nums = {4, 6, 7, 7};
    ListUtils.printLists(nonDecreasingSubsequences.findSubsequences(nums));
  }

  private List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    backTrack(nums, current, result, 0);
    return result;
  }

  private void backTrack(int[] nums, List<Integer> current, List<List<Integer>> result, int index) {
    if (current.size() > 1) {
      result.add(new ArrayList<>(current));
    }
    Set<Integer> used = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      if (used.contains(nums[i])) {
        continue;
      }
      if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
        current.add(nums[i]);
        backTrack(nums, current, result, i + 1);
        current.remove(current.size() - 1);
        used.add(nums[i]);
      }
    }
  }
}