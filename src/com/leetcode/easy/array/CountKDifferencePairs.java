package com.leetcode.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/04/23, Time:    12:56 pm
 * https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
 */
public class CountKDifferencePairs {

  public static void main(String[] args) {
    CountKDifferencePairs countKDifferencePairs = new CountKDifferencePairs();
    int[] nums = new int[]{3, 2, 1, 5, 4};
    int k = 2;
    System.out.println(countKDifferencePairs.countKDifference(nums, k));
  }

  private int countKDifference(int[] nums, int k) {
    int ans = 0;
    int[] count = new int[101];
    for (int i : nums) {
      count[i]++;
    }
    for (int i = k + 1; i < 101; i++) {
      ans += count[i] * count[i - k];
    }
    return ans;
  }
}