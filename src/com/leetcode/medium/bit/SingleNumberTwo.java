package com.leetcode.medium.bit;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    31/05/24,
 * Time:    10:12 am
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/description/
 */
public class SingleNumberTwo {
  public static void main(String[] args) {
    SingleNumberTwo singleNumberTwo = new SingleNumberTwo();
    int[] nums = {2, 2, 3, 2};
    System.out.println(singleNumberTwo.singleNumberTwo(nums));
  }

  private int singleNumberTwo(int[] nums) {
    int result = 0;
    for (int k = 0; k < 32; k++) {
      int countZero = 0, countOne = 0;
      int temp = 1 << k;
      for (int num : nums) {
        if ((num & temp) == 0) {
          countZero++;
        } else {
          countOne++;
        }
      }
      if (countOne % 3 == 1) {
        result |= temp;
      }
    }
    return result;
  }
}