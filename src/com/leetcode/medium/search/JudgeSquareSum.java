package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/06/24,
 * Time:    7:28 am
 * 633. Sum of Square Numbers
 * https://leetcode.com/problems/sum-of-square-numbers/description/?envType=daily-question&envId=2024-06-17
 */
public class JudgeSquareSum {
  public static void main(String[] args) {
    JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
    int c = 4;
    System.out.println(judgeSquareSum.judgeSquareSum(c));
  }

  private boolean judgeSquareSum(int c) {
    long low = 0;
    long high = (long) Math.sqrt(c);
    while (low <= high) {
      long sumOfSquares = low * low + high * high;
      if (sumOfSquares < c) {
        low++;
      } else if (sumOfSquares > c) {
        high--;
      } else {
        return true;
      }
    }
    return false;
  }
}