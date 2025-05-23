package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    11:19 PM
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {

  public static void main(String[] args) {
    ArrangingCoins arrangingCoins = new ArrangingCoins();
    System.out.println(arrangingCoins.arrangeCoins(5));
  }

  private int arrangeCoins(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Input Number is invalid. Only positive numbers are allowed");
    }
    if (n <= 1) {
      return n;
    }
    if (n <= 3) {
      return n == 3 ? 2 : 1;
    }

    // Binary Search space will start from 2 to n/2.
    long start = 2;
    long end = n / 2;
    while (start <= end) {
      long mid = start + (end - start) / 2;
      long coinsFilled = mid * (mid + 1) / 2;
      if (coinsFilled == n) {
        return (int) mid;
      }
      if (coinsFilled < n) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    // Since at this point start > end, start will start pointing to a value greater
    // than the desired result. We will return end as it will point to the correct
    // int value.
    return (int) end;
  }
}