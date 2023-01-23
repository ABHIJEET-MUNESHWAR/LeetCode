package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    22/01/23, Time:    7:03 pm
 * https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 */
public class MinimumSum {

  public static void main(String[] args) {
    MinimumSum minimumSum = new MinimumSum();
    int num = 4009;
    System.out.println(minimumSum.minimumSum(num));
  }

  private int minimumSum(int num) {
    int sum = 0;
    int size = Integer.toString(num).length();
    int[] numArray = new int[size];
    for (int i = 0; i < size; i++) {
      numArray[i] = num % 10;
      num = num / 10;
    }
    Arrays.sort(numArray);
    int num1 = 0, num2 = 0;
    for (int i = 0; i < size; i += 2) {
      num1 = num1 * 10 + numArray[i];
      num2 = num2 * 10 + numArray[i + 1];
    }
    sum = num1 + num2;
    return sum;
  }
}