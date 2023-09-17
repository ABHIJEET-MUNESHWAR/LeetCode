package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/09/23,
 * Time:    7:34 pm
 * https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/
 */
public class FindGCD {
  public static void main(String[] args) {
    FindGCD findGCD = new FindGCD();
    int[] nums = {2, 5, 6, 9, 10};
    System.out.println(findGCD.findGCD(nums));
  }

  private int findGCD(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i : nums) {
      if (min > i) {
        min = i;
      }
      if (max < i) {
        max = i;
      }
    }
    return gcd(min, max);
  }

  private int gcd(int min, int max) {
    int maxDivisor = 0;
    for (int i = 1; i <= min; i++) {
      if (min % i == 0 && max % i == 0) {
        maxDivisor = i;
      }
    }
    return maxDivisor;
  }
}