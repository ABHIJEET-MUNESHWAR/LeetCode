package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    12/04/22, Time:    9:35 AM
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

  public static void main(String[] args) {
    SingleNumber singleNumber = new SingleNumber();
    int[] nums = new int[]{2,2,1};
    //int[] nums = new int[]{4,1,2,1,2};
    System.out.println("Single Number: " + singleNumber.getSingleNumber(nums));
  }

  private Integer getSingleNumber(int[] nums) {
    int res = 0;
    for (int num : nums) {
      res = res ^ num;
    }
    return res;
  }
}