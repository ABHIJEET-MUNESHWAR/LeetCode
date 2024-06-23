package com.leetcode.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/06/24,
 * Time:    2:40 pm
 * 1248. Count Number of Nice SubArrays
 * https://leetcode.com/problems/count-number-of-nice-subarrays/description/?envType=daily-question&envId=2024-06-22
 */
public class CountNumberOfNiceSubArrays {
  public static void main(String[] args) {
    CountNumberOfNiceSubArrays countNumberOfNiceSubArrays = new CountNumberOfNiceSubArrays();
    int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
    int k = 2;
    System.out.println(countNumberOfNiceSubArrays.numberOfSubArraysMap(nums, k));
    System.out.println(countNumberOfNiceSubArrays.numberOfSubArraysSlidingWindow(nums, k));
  }

  private int numberOfSubArraysSlidingWindow(int[] nums, int k) {
    int size = nums.length;
    int result = 0;
    int oddCount = 0;
    int previousCount = 0;
    int left = 0, right = 0;
    while (right < size) {
      if (nums[right] % 2 == 1) {
        oddCount++;
        previousCount = 0;
      }
      while (oddCount == k) {
        previousCount++;
        if (left < size && nums[left] % 2 == 1) {
          oddCount--;
        }
        left++;
      }
      result += previousCount;
      right++;
    }
    return result;
  }

  private int numberOfSubArraysMap(int[] nums, int k) {
    int n = nums.length;
    int count = 0;
    int oddsCount = 0;
    Map<Integer, Integer> oddsFrequencyMap = new HashMap<>();
    oddsFrequencyMap.put(0, 1);
    for (int i = 0; i < n; i++) {
      oddsCount += nums[i] % 2;
      int key = oddsCount - k;
      if (oddsFrequencyMap.containsKey(key)) {
        count += oddsFrequencyMap.get(key);
      }
      oddsFrequencyMap.put(oddsCount, oddsFrequencyMap.getOrDefault(oddsCount, 0) + 1);
    }
    return count;
  }
}