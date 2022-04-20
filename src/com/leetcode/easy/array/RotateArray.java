package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/04/22, Time:    5:25 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 */
public class RotateArray {

  public static void main(String[] args) {
    int k = 3;
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    RotateArray rotateArray = new RotateArray();
    rotateArray.rotateArray(nums, k);
  }

  private void rotateArray(int[] nums, int k) {
    int len = nums.length;
    if (len == 1) {
      return;
    }
    if (k > len) {
      k = k % len;
    }
    int firstHalf = len - k;
    // reverse first half
    for (int i = 0, j = firstHalf - 1; i < firstHalf - 1 && j >= 0; i++, j--) {
      if (i >= j) {
        break;
      }
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
    // reverse 2nd half
    for (int i = firstHalf, j = len - 1; i < len && j >= firstHalf; i++, j--) {
      if (i >= j) {
        break;
      }
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
    for (int i = 0, j = len - 1; i < len && j >= 0; i++, j--) {
      if (i >= j) {
        break;
      }
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
    System.out.println("nums = " + Arrays.toString(nums));
  }
}