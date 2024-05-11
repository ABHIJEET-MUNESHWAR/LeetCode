package com.leetcode.medium.math;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    6:20 pm
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/description/
 */
public class CombinationSum2 {
  public static void main(String[] args) {
    CombinationSum2 combinationSum2 = new CombinationSum2();
    int[] candidates = {2, 3, 6, 7};
    int target = 7;
    ListUtils.printLists(combinationSum2.combinationSum2(candidates, target));
  }

  public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;

  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
    if (remain < 0) {
      return;
    } else if (remain == 0) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i] == nums[i - 1]) {
          continue; // skip duplicates
        }
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, remain - nums[i], i + 1);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}