package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/03/24,
 * Time:    7:09 am
 * <a href="https://leetcode.com/problems/count-elements-with-maximum-frequency/?envType=daily-question&envId=2024-03-08">3005. Count Elements With Maximum Frequency</a>
 */
public class MaxFrequencyElements {
  public static void main(String[] args) {
    MaxFrequencyElements maxFrequencyElements = new MaxFrequencyElements();
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(maxFrequencyElements.maxFrequencyElements(nums));
  }

  private int maxFrequencyElements(int[] nums) {
    Map<Integer, Integer> numToFreqMap = new HashMap<>();
    for (int num : nums) {
      numToFreqMap.put(num, numToFreqMap.getOrDefault(num, 0) + 1);
    }
    int max = Integer.MIN_VALUE;
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : numToFreqMap.entrySet()) {
      if (max < entry.getValue()) {
        max = entry.getValue();
      }
    }
    for (Map.Entry<Integer, Integer> entry : numToFreqMap.entrySet()) {
      if (entry.getValue() == max) {
        count += max;
      }
    }
    return count;
  }
}