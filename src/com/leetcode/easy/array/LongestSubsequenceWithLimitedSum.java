package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/12/23,
 * Time:    12:38 pm
 */
public class LongestSubsequenceWithLimitedSum {
  public static void main(String[] args) {
    LongestSubsequenceWithLimitedSum longestSubsequenceWithLimitedSum =
        new LongestSubsequenceWithLimitedSum();
    int[] nums = {4, 5, 2, 1};
    int[] queries = {3, 10, 21};
    ArrayUtils.printArray(longestSubsequenceWithLimitedSum.answerQueries(nums, queries));
  }

  private int[] answerQueries(int[] nums, int[] queries) {
    int queriesSize = queries.length;
    int[] answer = new int[queriesSize];
    Arrays.sort(nums);
    int[] prefixSum = getPrefixSum(nums);
    for (int i = 0; i < queriesSize; i++) {
      answer[i] = findAllNumbersSmaller(prefixSum, queries[i]);
    }
    return answer;
  }

  private int findAllNumbersSmaller(int[] nums, int element) {
    int numsSize = nums.length;
    int left = 0;
    int right = numsSize - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == element) {
        return mid + 1;
      } else if (nums[mid] < element) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left] <= element ? left + 1 : left;
  }

  private int[] getPrefixSum(int[] nums) {
    int numsSize = nums.length;
    int[] prefixSum = new int[numsSize];
    int sum = 0;
    for (int i = 0; i < numsSize; i++) {
      sum += nums[i];
      prefixSum[i] = sum;
    }
    return prefixSum;
  }
}