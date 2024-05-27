package com.leetcode.medium.math;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    5:20 pm
 * 78. Subsets
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets {
  public static void main(String[] args) {
    Subsets subsets = new Subsets();
    int[] nums = {1, 2, 3};
    ListUtils.printLists(subsets.subsets(nums));
    System.out.println();
    ListUtils.printLists(subsets.subsetsTakeOrSkip(nums));
  }

  List<List<Integer>> result = new ArrayList<>();

  private List<List<Integer>> subsetsTakeOrSkip(int[] nums) {
    List<Integer> temp = new ArrayList<>();
    subsetsTakeOrSkip(nums, 0, temp);
    return result;
  }

  private void subsetsTakeOrSkip(int[] nums, int index, List<Integer> temp) {
    if (index >= nums.length) {
      result.add(new ArrayList<>(temp));
      return;
    }
    temp.add(nums[index]);
    subsetsTakeOrSkip(nums, index + 1, temp);
    temp.remove(temp.size() - 1);
    subsetsTakeOrSkip(nums, index + 1, temp);
  }

  private List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(result, new ArrayList<Integer>(), nums, 0);
    return result;
  }

  private void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, int start) {
    result.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      backtrack(result, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}