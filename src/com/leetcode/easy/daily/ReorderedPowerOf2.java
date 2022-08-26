package com.leetcode.easy.daily;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    26/08/22, Time:    6:18 AM
 */
public class ReorderedPowerOf2 {

  public static void main(String[] args) {
    ReorderedPowerOf2 reorderedPowerOf2 = new ReorderedPowerOf2();
    System.out.println("ReorderedPowerOf2: " + reorderedPowerOf2.reorderedPowerOf2(8));
  }

  private boolean reorderedPowerOf2(int n) {
    int[] countArray = getCountArray(n);
    int num = 1;
    for (int i = 0; i < 31; i++) {
      if (Arrays.equals(countArray, getCountArray(num))) {
        return true;
      } else {
        num = num << 1;
      }
    }
    return false;
  }

  private int[] getCountArray(int n) {
    int[] countArray = new int[10];
    while (n > 0) {
      countArray[n % 10]++;
      n = n / 10;
    }
    return countArray;
  }
}