package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    28/08/22, Time:    8:08 AM
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {

  public static void main(String[] args) {
    Sqrt sqrt = new Sqrt();
    System.out.println(sqrt.mySqrt(36));
  }

  private int mySqrt(int x) {
    if (x <= 1) {
      return x;
    }
    int start = 0;
    int end = x / 2;
    while (start < end) {
      int mid = start + (end - start) / 2 + 1;
      int div = x / mid;
      if (div == mid) {
        return div;
      } else if (div > mid) {
        start = mid;
      } else if (div < mid) {
        end = mid - 1;
      }
    }
    return start;
  }
}