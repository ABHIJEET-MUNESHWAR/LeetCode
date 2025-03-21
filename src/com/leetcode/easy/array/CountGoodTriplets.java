package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/07/23,
 * Time:    10:56 am
 * https://leetcode.com/problems/count-good-triplets/
 */
public class CountGoodTriplets {
  public static void main(String[] args) {
    CountGoodTriplets countGoodTriplets = new CountGoodTriplets();
    int[] arr = {3, 0, 1, 1, 9, 7};
    int a = 7, b = 2, c = 3;
    System.out.println(countGoodTriplets.countGoodTriplets(arr, a, b, c));
  }

  private int countGoodTriplets(int[] arr, int a, int b, int c) {
    int count = 0;
    int length = arr.length;
    for (int i = 0; i < length - 2; i++) {
      for (int j = i + 1; j < length - 1; j++) {
        for (int k = j + 1; k < length; k++) {
          if (Math.abs(arr[i] - arr[j]) <= a
              && Math.abs(arr[j] - arr[k]) <= b
              && Math.abs(arr[i] - arr[k]) <= c) {
            count++;
          }
        }
      }
    }
    return count;
  }
}