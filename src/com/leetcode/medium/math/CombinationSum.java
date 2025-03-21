package com.leetcode.medium.math;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    6:11 pm
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {
  public static void main(String[] args) {
    CombinationSum combinationSum = new CombinationSum();
    int[] candidates = {2, 3, 6, 7};
    int target = 7;
    ListUtils.printLists(combinationSum.combinationSum(candidates, target));
  }

  private List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(result, new ArrayList<Integer>(), candidates, target, 0);
    return result;
  }

  private void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, int remain, int start) {
    if (remain == 0) {
      result.add(new ArrayList<>(tempList));
    } else if (remain < 0) {
      return;
    } else {
      for (int i = start; i < nums.length; i++) {
        tempList.add(nums[i]);
        backtrack(result, tempList, nums, remain - nums[i], i);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}