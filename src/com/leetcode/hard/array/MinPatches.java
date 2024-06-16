package com.leetcode.hard.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/06/24,
 * Time:    2:15 pm
 * 330. Patching Array
 * https://leetcode.com/problems/patching-array/description/?envType=daily-question&envId=2024-06-16
 */
public class MinPatches {
  public static void main(String[] args) {
    MinPatches obj = new MinPatches();
    int[] nums = {1, 5, 10};
    int n = 20;
    System.out.println(obj.minPatches(nums, n));
  }

  private int minPatches(int[] nums, int n) {
    int totalPatches = 0;
    long maxReach = 0;
    int i = 0;
    while (maxReach < n) {
      if (i < nums.length && nums[i] <= maxReach + 1) {
        maxReach += nums[i];
        i++;
      } else {
        maxReach += (maxReach + 1);
        totalPatches++;
      }
    }
    return totalPatches;
  }
}