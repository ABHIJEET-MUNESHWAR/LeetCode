package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    9:22am
 */
public class CountSymmetricIntegers {
  public static void main(String[] args) {
    CountSymmetricIntegers countSymmetricIntegers = new CountSymmetricIntegers();
    int low = 1200, high = 1230;
    System.out.println(countSymmetricIntegers.countSymmetricIntegers(low, high));
  }

  private int countSymmetricIntegers(int low, int high) {
    int count = 0;
    for (int i = low; i <= high; i++) {
      String numString = String.valueOf(i);
      int size = numString.length();
      int sum = 0;
      for (int j = 0; j < (size / 2); j++) {
        sum += numString.charAt(j) - numString.charAt(size - j - 1);
      }
      if (size % 2 == 0 && sum == 0) {
        count++;
      }
    }
    return count;
  }
}