package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    12/04/22, Time:    9:35 AM
 * https://leetcode.com/problems/single-number-ii/
 * https://www.youtube.com/watch?v=jO7uGdvGGC4
 */
public class SingleNumber2 {

  public static void main(String[] args) {
    SingleNumber2 singleNumber2 = new SingleNumber2();
    int[] nums = new int[]{2, 2, 3, 2};
    //int[] nums = new int[]{0, 1, 0, 1, 0, 1, 99};
    //int[] nums = new int[]{30000, 500, 100, 30000, 100, 30000, 100};

    System.out.println("Single Number: " + singleNumber2.getSingleNumber(nums));
  }

  private Integer getSingleNumber(int[] nums) {
    int n = nums.length;
    int singleNumber = 0;
    for (int i = 0; i < 32; i++) {
      int sum = 0;
      for (int j = 0; j < n; j++) {
        if ((nums[j] >> i & 1) == 1) {
          sum++;
        }
      }
      sum %= 3;
      singleNumber = singleNumber | sum << i;
    }
    return singleNumber;
  }
}