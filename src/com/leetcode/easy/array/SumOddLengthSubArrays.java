package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    23/03/23, Time:    11:02 am
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */
public class SumOddLengthSubArrays {

  public static void main(String[] args) {
    SumOddLengthSubArrays sumOddLengthSubArrays = new SumOddLengthSubArrays();
    int[] arr = new int[]{1, 4, 2, 5, 3};
    System.out.println(sumOddLengthSubArrays.sumOddLengthSubArrays(arr));
    System.out.println(sumOddLengthSubArrays.sumOddLengthSubArrays2(arr));
  }

  private int sumOddLengthSubArrays(int[] arr) {
    int sum = 0;
    int size = arr.length;
    for (int i = 1; i <= size; i += 2) {
      int startIndex = 0;
      int endIndex = startIndex + i;
      while (endIndex <= size) {
        for (int j = startIndex; j < endIndex; j++) {
          sum += arr[j];
        }
        startIndex++;
        endIndex++;
      }
    }
    return sum;
  }

  private int sumOddLengthSubArrays2(int[] arr) {
    int sum = 0;
    int size = arr.length;
    for (int i = 0; i < size; i++) {
      sum += (((i + 1) * (size - i) + 1 ) / 2) * arr[i];
    }
    return sum;
  }
}