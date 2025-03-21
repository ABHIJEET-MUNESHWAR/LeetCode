package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/07/23,
 * Time:    3:25 pm
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 */
public class SubSetXORSum {
  public static void main(String[] args) {
    SubSetXORSum subSetXORSum = new SubSetXORSum();
    int[] nums = {5, 1, 6};
    System.out.println(subSetXORSum.subSetXORSum(nums));
  }

  private int subSetXORSum(int[] nums) {
    return helper(nums, 0, 0);
  }

  private int helper(int[] nums, int level, int currentXOR) {
    if (level == nums.length) {
      return currentXOR;
    }
    int include = helper(nums, level + 1, currentXOR ^ nums[level]);
    int exclude = helper(nums, level + 1, currentXOR);

    return include + exclude;
  }
}