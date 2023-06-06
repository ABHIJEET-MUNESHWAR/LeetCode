package com.leetcode.easy.math;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/06/23,
 * Time:    6:22 pm
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 */
public class ArithmeticProgression {
  public static void main(String[] args) {
    ArithmeticProgression arithmeticProgression = new ArithmeticProgression();
    int[] arr = {1, 3, 5};
    System.out.println(arithmeticProgression.canMakeArithmeticProgression(arr));
  }

  private boolean canMakeArithmeticProgression(int[] arr) {
    Arrays.sort(arr);
    int size = arr.length;
    for (int i = 1; i < size - 1; i++) {
      if ((arr[i] - arr[i - 1]) != (arr[i + 1] - arr[i])) {
        return false;
      }
    }
    return true;
  }
}