package com.leetcode.medium.math;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    5:28 pm
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/description/
 */
public class SubsetsWithDup {
  public static void main(String[] args) {
    SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
    int[] nums = {1, 2, 2};
    ListUtils.printLists(subsetsWithDup.subsetsWithDup(nums));
  }

  private List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
    list.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue; // skip duplicates
      }
      tempList.add(nums[i]);
      backtrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}