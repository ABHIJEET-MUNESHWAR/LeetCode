package com.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    12/04/22, Time:    9:35 AM
 * https://leetcode.com/problems/single-number-iii/
 * https://leetcode.com/problems/single-number-iii/discuss/68901/Sharing-explanation-of-the-solution
 */
public class SingleNumber3 {

  public static void main(String[] args) {
    SingleNumber3 singleNumber = new SingleNumber3();
    int[] nums = new int[]{1, 2, 1, 3, 2, 5};
    //int[] nums = new int[]{-1, 0};
    //int[] nums = new int[]{0, 1};

    System.out.println("Single Number: " + Arrays.toString(singleNumber.getSingleNumber(nums)));
  }

  private int[] getSingleNumber(int[] nums) {
    int temp = 0;
    for (int n : nums) {
      temp ^= n;
    }

    int partition = -1;
    for (int i = 0; i < 32; i++) {
      if (((temp >> i) & 1) == 1) {
        partition = i;
        break;
      }
    }

    int single1 = 0, single2 = 0;
    for (int num : nums) {
      if (((num >> partition) & 1) == 1) {
        single1 ^= num;
      }
      if (((num >> partition) & 1) == 0) {
        single2 ^= num;
      }
    }
    return new int[]{single1, single2};
  }
}