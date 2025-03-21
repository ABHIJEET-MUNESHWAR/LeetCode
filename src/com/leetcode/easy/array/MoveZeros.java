package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    23/06/22, Time:    6:50 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 */
public class MoveZeros {

  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 0, 3, 12};
//    int[] nums = new int[]{0};
    MoveZeros moveZeros = new MoveZeros();
    moveZeros.moveZeros(nums);
  }

  private void moveZeros(int[] nums) {
    int len = nums.length;
    int j = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] != 0) {
        nums[j++] = nums[i];
      }
    }
    while (j < len) {
      nums[j++] = 0;
    }
    System.out.println("nums3 = " + Arrays.toString(nums));
  }
}