package com.leetcode.companies.meta.practice.fusion;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    11/08/22, Time:    7:11 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/
 */
public class Merge2SortedArrays {

  public static void main(String[] args) {
    Merge2SortedArrays merge2SortedArrays = new Merge2SortedArrays();
    int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
    int m = 3;
    int[] num2 = new int[]{2, 5, 6};
    int n = 3;
    merge2SortedArrays.merge(num1, m, num2, n);
  }

  private void merge(int[] num1, int m, int[] num2, int n) {
    int size = m + n - 1;
    m--;
    n--;
    while (m >= 0 && n >= 0) {
      if (num1[m] > num2[n]) {
        num1[size--] = num1[m--];
      } else {
        num1[size--] = num2[n--];
      }
    }
    while (n >= 0) {
      num1[size--] = num2[n--];
    }
    System.out.println(Arrays.toString(num1));
  }
}