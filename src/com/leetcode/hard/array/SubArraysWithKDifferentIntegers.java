package com.leetcode.hard.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/04/24,
 * Time:    9:31 pm
 * 992. SubArrays with K Different Integers
 * https://leetcode.com/problems/subarrays-with-k-different-integers/description/?envType=daily-question&envId=2024-03-30
 */
public class SubArraysWithKDifferentIntegers {
  public static void main(String[] args) {
    SubArraysWithKDifferentIntegers subArraysWithKDifferentIntegers =
        new SubArraysWithKDifferentIntegers();
    int[] nums = {1, 2, 1, 2, 3};
    int k = 2;
    System.out.println(subArraysWithKDifferentIntegers.subarraysWithKDistinct(nums, k));
  }

  private int subarraysWithKDistinct(int[] nums, int k) {
    return countOfSubarraysWithAtMostK(nums, k) - countOfSubarraysWithAtMostK(nums, k - 1);
  }

  private int countOfSubarraysWithAtMostK(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    int start = 0;
    int end = 0;
    int count = 0;
    int size = nums.length;
    while (end < size) {
      // Expansion
      frequencyMap.put(nums[end], frequencyMap.getOrDefault(nums[end], 0) + 1);
      // Shrinking (At most K elements are supported)
      while (frequencyMap.size() > k) {
        frequencyMap.put(nums[start], frequencyMap.getOrDefault(nums[start], 0) - 1);
        if (frequencyMap.get(nums[start]) == 0) {
          frequencyMap.remove(nums[start]);
        }
        start++;
      }
      count += (end - start + 1);
      end++;
    }
    return count;
  }
}