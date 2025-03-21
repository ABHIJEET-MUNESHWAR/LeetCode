package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    11:53pm
 * https://leetcode.com/problems/divide-array-into-equal-pairs/description/
 */
public class DivideArray {
  public static void main(String[] args) {
    DivideArray divideArray = new DivideArray();
    int[] nums = {3, 2, 3, 2, 2, 2};
    System.out.println(divideArray.divideArray(nums));
  }

  private boolean divideArray(int[] nums) {
    Map<Integer, Integer> numToFreq = new HashMap<>();
    for (int num : nums) {
      numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
      if (entry.getValue() % 2 != 0) {
        return false;
      }
    }
    return true;
  }
}