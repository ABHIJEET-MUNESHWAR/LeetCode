package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    3:51 pm
 */
public class RepeatedNTimes {
  public static void main(String[] args) {
    RepeatedNTimes repeatedNTimes = new RepeatedNTimes();
    int[] nums = {5, 1, 5, 2, 5, 3, 5, 4};
    System.out.println(repeatedNTimes.repeatedNTimes(nums));
  }

  private int repeatedNTimes(int[] nums) {
    int size = nums.length;
    for (int i = 2; i < size; i++) {
      if (nums[i] == nums[i - 1] || nums[i] == nums[i - 2]) {
        return nums[i];
      }
    }
    return nums[size - 1];
  }
}