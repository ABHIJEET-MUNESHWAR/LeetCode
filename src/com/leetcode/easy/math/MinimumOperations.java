package com.leetcode.easy.math;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/10/23,
 * Time:    11:26am
 * https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 */
public class MinimumOperations {
  public static void main(String[] args) {
    MinimumOperations minimumOperations = new MinimumOperations();
    int[] nums = {1, 5, 0, 3, 5};
    System.out.println(minimumOperations.minimumOperations(nums));
  }

  private int minimumOperations(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (num != 0) {
        set.add(num);
      }
    }
    return set.size();
  }
}