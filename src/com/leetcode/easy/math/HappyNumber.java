package com.leetcode.easy.math;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    31/08/22, Time:    7:21 PM
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

  public static void main(String[] args) {
    HappyNumber happyNumber = new HappyNumber();
    System.out.println(happyNumber.isHappy(7));
  }

  private boolean isHappy(int n) {
    int slow = n;
    int fast = n;
    do {
      slow = getDigitSquareSum(slow);
      fast = getDigitSquareSum(fast);
      fast = getDigitSquareSum(fast);
    } while (slow != fast);
    if (slow == 1) {
      return true;
    } else {
      return false;
    }
  }

  private int getDigitSquareSum(int n) {
    int sum = 0;
    while (n > 0) {
      int mod = n % 10;
      sum += mod * mod;
      n = n / 10;
    }
    return sum;
  }

  private boolean isHappyUsingHashSet(int n) {
    Set<Integer> set = new HashSet<>();
    while (n > 0) {
      int sum = 0;
      while (n != 0) {
        int mod = n % 10;
        sum += mod * mod;
        n = n / 10;
      }
      n = sum;
      if (set.contains(sum) || sum == 1) {
        break;
      }
      set.add(sum);
    }
    if (n == 1) {
      return true;
    } else {
      return false;
    }
  }
}