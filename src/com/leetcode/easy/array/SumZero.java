package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    12:09 pm
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 */
public class SumZero {
  public static void main(String[] args) {
    SumZero sumZero = new SumZero();
    ArrayUtils.printArray(sumZero.sumZero(1));
  }

  private int[] sumZero(int n) {
    int[] answer = new int[n];
    int mid = n / 2;
    for (int i = 0, j = n - 1; i < j; i++, j--) {
      answer[i] = -mid;
      answer[j] = mid;
      mid--;
    }
    return answer;
  }
}