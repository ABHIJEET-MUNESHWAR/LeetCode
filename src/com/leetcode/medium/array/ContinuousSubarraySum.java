package com.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/06/24,
 * Time:    11:33 am
 * 523. Continuous Subarray Sum
 * https://leetcode.com/problems/continuous-subarray-sum/description/?envType=daily-question&envId=2024-06-08
 */
public class ContinuousSubarraySum {
  public static void main(String[] args) {
    ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
    int[] nums = {23, 2, 4, 6, 7};
    int k = 6;
    System.out.println(continuousSubarraySum.continuousSubarraySum(nums, k));
  }

  private boolean continuousSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> remainderVsIndexMap = new HashMap<>();
    remainderVsIndexMap.put(0, -1);
    int size = nums.length;
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum += nums[i];
      int reminder = sum % k;
      if (remainderVsIndexMap.containsKey(reminder)) {
        if ((i - remainderVsIndexMap.get(reminder)) >= 2) {
          return true;
        }
      } else {
        remainderVsIndexMap.put(reminder, i);
      }
    }
    return false;
  }
}