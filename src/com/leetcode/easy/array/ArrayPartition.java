package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    26/11/22, Time:    7:12 pm
 * https://leetcode.com/problems/array-partition/
 */
public class ArrayPartition {

  public static void main(String[] args) {
    ArrayPartition arrayPartition = new ArrayPartition();
    int[] nums = new int[]{1,4,3,2};
    System.out.println(arrayPartition.arrayPairSum(nums));
  }

  private int arrayPairSum(int[] nums) {
    int sum = 0;
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i < len; i += 2) {
      sum += nums[i];
    }
    return sum;
  }
}