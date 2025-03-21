package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/06/23,
 * Time:    8:28 pm
 * https://leetcode.com/problems/neither-minimum-nor-maximum/
 */
public class FindNonMinOrMax {
  public static void main(String[] args) {
    FindNonMinOrMax findNonMinOrMax = new FindNonMinOrMax();
    int[] nums = {3, 30, 24};
    System.out.println(findNonMinOrMax.findNonMinOrMax(nums));
  }

  private int findNonMinOrMax(int[] nums) {
    int size = nums.length;
    if (size < 3) {
      return -1;
    } else {
      int a = Math.min(nums[0], nums[1]);
      int b = Math.max(nums[0], nums[1]);
      int c = nums[2];
      if (c <
          a) { //since a cannot be the minimum as it is bigger than one number and smaller than b
        return a;
      }
      if (b < c) { //since b cannot be minimum as it is bigger than a and cannot be max as it is < b
        return b;
      }
      if (a < c && c < b) { // since c cannot be the maximum nor the minimum now
        return c;
      }
    }
    return -1;
  }
}