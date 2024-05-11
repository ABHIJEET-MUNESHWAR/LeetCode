package com.leetcode.medium.math;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    5:39 pm
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/description/
 */
public class PermuteUnique {
  public static void main(String[] args) {
    PermuteUnique permuteUnique = new PermuteUnique();
    int[] nums = {1, 2, 2};
    ListUtils.printLists(permuteUnique.permuteUnique(nums));
  }

  private List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
  }

  private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, boolean[] used) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
          continue;
        }
        used[i] = true;
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, used);
        used[i] = false;
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}