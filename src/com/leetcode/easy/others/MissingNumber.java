package com.leetcode.easy.others;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    6:28 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/722/
 */
public class MissingNumber {

  public static void main(String[] args) {
    MissingNumber missingNumber = new MissingNumber();
    int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
    System.out.println(missingNumber.getMissingNumber(nums));
  }

  private int getMissingNumber(int[] nums) {
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    int sum = 0;
    for (int i = 0; i <= len; i++) {
      sum += i;
    }
    int numSum = 0;
    for (int i = 0; i < len; i++) {
      numSum += nums[i];
    }
    return (sum - numSum);
  }
}