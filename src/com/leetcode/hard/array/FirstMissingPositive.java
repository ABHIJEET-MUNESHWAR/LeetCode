package com.leetcode.hard.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    26/03/24,
 * Time:    8:07 am
 * https://leetcode.com/problems/first-missing-positive/?envType=daily-question&envId=2024-03-26
 */
public class FirstMissingPositive {
  public static void main(String[] args) {
    FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
    int[] nums = {3, 4, -1, 1};
    System.out.println(firstMissingPositive.firstMissingPositive(nums));
  }

  private int firstMissingPositive(int[] nums) {
    int size = nums.length;
    boolean containsOne = false;
    for (int num : nums) {
      if (num == 1) {
        containsOne = true;
        break;
      }
    }
    if (!containsOne) {
      return 1;
    }
    if (size == 1) {
      return 2;
    }
    for (int i = 0; i < size; i++) {
      if (nums[i] <= 0 || nums[i] > size) {
        nums[i] = 1;
      }
    }
    for (int i = 0; i < size; i++) {
      int x = Math.abs(nums[i]);
      if (nums[x - 1] > 0) {
        nums[x - 1] *= -1;
      }
    }
    for (int i = 0; i < size; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return size + 1;
  }
}