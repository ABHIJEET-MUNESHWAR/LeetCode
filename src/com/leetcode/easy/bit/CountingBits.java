package com.leetcode.easy.bit;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    14/09/22, Time:    7:30 AM
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {

  public static void main(String[] args) {
    CountingBits countingBits = new CountingBits();
    System.out.println(countingBits.countBits(7));
  }

  private int[] countBits(int n) {
    int[] nums = new int[n + 1];
    nums[0] = 0;
    for (int i = 1; i <= n; i++) {
      if ((i & 1) == 0) {
        nums[i] = nums[i >> 1];
      } else {
        nums[i] = 1 + nums[i - 1];
      }
    }
    return nums;
  }
}