package com.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/07/24,
 * Time:    9:58 pm
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/description/?envType=daily-question&envId=2024-07-03
 */
public class MinDifference {
  public static void main(String[] args) {
    MinDifference minDifference = new MinDifference();
    int[] nums = {6, 6, 0, 1, 1, 4, 6};
    System.out.println(minDifference.minDifference(nums));
  }

  private int minDifference(int[] nums) {
    int size = nums.length;
    if (size < 5) {
      return 0;
    }
    Arrays.sort(nums);
    int minDifference = Integer.MAX_VALUE;
    for (int i = 0; i < 4; i++) {
      minDifference = Math.min(minDifference, Math.abs(nums[i] - nums[size + i - 4]));
    }
    return minDifference;
  }
}