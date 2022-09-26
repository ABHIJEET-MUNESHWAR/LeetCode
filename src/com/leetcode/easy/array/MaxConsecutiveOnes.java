package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/09/22, Time:    9:27 PM
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

  public static void main(String[] args) {
    MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
    int[] nums = new int[]{1, 1, 0, 1, 1, 1};
    System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
  }

  private int findMaxConsecutiveOnes(int[] nums) {
    int count = 0;
    int maxSoFar = 0;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      if (nums[i] == 1) {
        count++;
        maxSoFar = Math.max(count, maxSoFar);
      } else {
        count = 0;
      }
    }
    return maxSoFar;
  }
}