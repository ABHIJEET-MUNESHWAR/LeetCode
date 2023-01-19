package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    19/01/23, Time:    11:37 am
 * https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
 */
public class DifferenceOfSum {

  public static void main(String[] args) {
    DifferenceOfSum differenceOfSum = new DifferenceOfSum();
    int[] nums = new int[]{1, 15, 6, 3};
    System.out.println(differenceOfSum.differenceOfSum(nums));
  }

  private int differenceOfSum(int[] nums) {
    int elementSum = 0, digitSum = 0;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      elementSum += nums[i];
      if (nums[i] < 10) {
        digitSum += nums[i];
      } else {
        digitSum += getSumOfDigits(nums[i]);
      }
    }
    return Math.abs(elementSum - digitSum);
  }

  private int getSumOfDigits(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num = num / 10;
    }
    return sum;
  }
}