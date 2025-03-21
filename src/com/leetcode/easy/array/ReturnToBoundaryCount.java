package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/03/24,
 * Time:    9:33 am
 * https://leetcode.com/problems/ant-on-the-boundary/description/
 */
public class ReturnToBoundaryCount {
  public static void main(String[] args) {
    ReturnToBoundaryCount returnToBoundaryCount = new ReturnToBoundaryCount();
    int[] nums = {3, 2, -3, -4};
    System.out.println(returnToBoundaryCount.returnToBoundaryCount(nums));
  }

  private int returnToBoundaryCount(int[] nums) {
    int count = 0;
    int sum = 0;
    for (int num : nums) {
      sum += num;
      if (sum == 0) {
        count++;
      }
    }
    return count;
  }
}