package com.leetcode.easy.dynamicprogramming;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/08/22, Time:    6:43 PM 0, 1, 1, 2,
 * 3, 5, 8, 13, 21
 */
public class ClimbingStairs {

  public static void main(String[] args) {
    ClimbingStairs climbingStairs = new ClimbingStairs();
    System.out.println("Number of ways to climb stairs: " + climbingStairs.climbStairs(2));
  }

  private Integer climbStairs(int n) {
    int a = 1, b = 2, c = 0;
    if (n < 3) {
      return n;
    }
    for (int i = 0; i < n; i++) {c
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }
}