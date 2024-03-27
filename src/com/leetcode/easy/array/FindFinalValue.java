package com.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/03/24,
 * Time:    10:44 pm
 * https://leetcode.com/problems/keep-multiplying-found-values-by-two/
 */
public class FindFinalValue {
  public static void main(String[] args) {
    FindFinalValue findFinalValue = new FindFinalValue();
    int[] nums = {5, 3, 6, 1, 12};
    int original = 3;
    System.out.println(findFinalValue.findFinalValueSet(nums, original));
    System.out.println(findFinalValue.findFinalValueBoolArray(nums, original));
  }

  private int findFinalValueBoolArray(int[] nums, int original) {
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      if (nums[i] == original) {
        original *= 2;
        i = -1;
      }
    }
    return original;
  }

  private int findFinalValueSet(int[] nums, int original) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int num = original;
    while (set.contains(num)) {
      num = num * 2;
    }
    return num;
  }
}