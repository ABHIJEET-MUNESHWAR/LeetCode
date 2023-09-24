package com.leetcode.easy.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    1:34 pm
 * https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/
 */
public class SumIndicesWithKSetBits {
  public static void main(String[] args) {
    SumIndicesWithKSetBits sumIndicesWithKSetBits = new SumIndicesWithKSetBits();
    List<Integer> nums = new ArrayList<>(Arrays.asList(4,3,2,1));
    int k = 2;
    System.out.println(sumIndicesWithKSetBits.sumIndicesWithKSetBits(nums, k));
  }

  private int sumIndicesWithKSetBits(List<Integer> nums, int k) {
    int[] numbers = nums.stream().mapToInt(m -> m).toArray();
    int sum = 0;
    int size = nums.size();
    for (int i = 0; i < size; i++) {
      int n = i;
      int once = 0;
      while (n > 0) {
        if (n % 2 == 1) {
          once++;
        }
        n = n / 2;
      }
      if (once == k) {
        sum += numbers[i];
      }
    }
    return sum;
  }
}