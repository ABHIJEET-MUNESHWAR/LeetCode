package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/09/23,
 * Time:    10:49 am
 * https://leetcode.com/problems/sum-of-squares-of-special-elements/
 */
public class SumOfSquares {
  public static void main(String[] args) {
    SumOfSquares sumOfSquares = new SumOfSquares();
    int[] nums = {2, 7, 1, 19, 18, 3};
    System.out.println(sumOfSquares.sumOfSquares(nums));
  }

  private int sumOfSquares(int[] nums) {
    int sum = 0;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int index = i + 1;
      if (size % (index) == 0) {
        sum += (nums[i] * nums[i]);
      }
    }
    return sum;
  }
}