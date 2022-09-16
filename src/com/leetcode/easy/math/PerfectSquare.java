package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    16/09/22, Time:    9:40 AM
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class PerfectSquare {

  public static void main(String[] args) {
    PerfectSquare perfectSquare = new PerfectSquare();
    System.out.println(perfectSquare.isPerfectSquare(1));
  }

  private boolean isPerfectSquare(int num) {
    int left = 1;
    int right = num;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid < num / mid) {
        left = mid + 1;
      } else if (mid > num / mid) {
        right = mid - 1;
      } else {
        return num % mid == 0;
      }
    }
    return false;
  }
}