package com.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/06/24,
 * Time:    12:25 pm
 * 974. Subarray Sums Divisible by K
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/?envType=daily-question&envId=2024-06-09
 */
public class SubArraysDivByK {
  public static void main(String[] args) {
    SubArraysDivByK subArraysDivByK = new SubArraysDivByK();
    int[] nums = {4, 5, 0, -2, -3, 1};
    int k = 5;
    System.out.println(subArraysDivByK.subArraysDivByK(nums, k));
  }

  private int subArraysDivByK(int[] nums, int k) {
    int size = nums.length;
    int result = 0;
    Map<Integer, Integer> reminderVsCountMap = new HashMap<>();
    reminderVsCountMap.put(0, 1);
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum += nums[i];
      int reminder = sum % k;
      if (reminder < 0) {
        reminder += k;
      }
      if (reminderVsCountMap.containsKey(reminder)) {
        result += reminderVsCountMap.get(reminder);
        reminderVsCountMap.put(reminder, reminderVsCountMap.get(reminder) + 1);
      } else {
        reminderVsCountMap.put(reminder, 1);
      }
    }
    return result;
  }
}