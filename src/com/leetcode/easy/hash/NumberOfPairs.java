package com.leetcode.easy.hash;

import com.leetcode.utils.ArrayUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/09/23,
 * Time:    2:54 am
 * https://leetcode.com/problems/maximum-number-of-pairs-in-array/
 */
public class NumberOfPairs {
  public static void main(String[] args) {
    NumberOfPairs numberOfPairs = new NumberOfPairs();
    int[] nums = {0};
    ArrayUtils.printArray(numberOfPairs.numberOfPairs(nums));
  }

  private int[] numberOfPairs(int[] nums) {
    int totalPairs = 0;
    int totalRemainingNumbers = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int k = entry.getKey();
      int v = entry.getValue();
      totalPairs += k = v / 2;
      totalRemainingNumbers += v % 2;
    }
    return new int[] {totalPairs, totalRemainingNumbers};
  }
}