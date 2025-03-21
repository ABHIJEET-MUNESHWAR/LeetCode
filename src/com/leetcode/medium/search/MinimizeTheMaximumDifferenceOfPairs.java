package com.leetcode.medium.search;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/07/24,
 * Time:    4:09 pm
 * 2616. Minimize the Maximum Difference of Pairs
 * https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/
 */
public class MinimizeTheMaximumDifferenceOfPairs {
  public static void main(String[] args) {
    MinimizeTheMaximumDifferenceOfPairs solution = new MinimizeTheMaximumDifferenceOfPairs();
    int[] nums = {10, 1, 2, 7, 1, 3};
    int p = 2;
    System.out.println(solution.minimizeMax(nums, p));
  }

  private int minimizeMax(int[] nums, int p) {
    int n = nums.length;
    Arrays.sort(nums);
    int result = Integer.MAX_VALUE;
    int left = 0;
    int right = nums[n - 1] - nums[0];
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (isValid(nums, mid, p)) {
        right = mid - 1;
        result = mid;
      } else {
        left = mid + 1;
      }
    }
    return result;
  }

  private boolean isValid(int[] nums, int mid, int p) {
    int totalValidPairs = 0;
    for (int i = 0; i < nums.length - 1; i+=2) {
      int diff = nums[i + 1] - nums[i];
      if (diff <= mid) {
        totalValidPairs++;
      }
    }
    return totalValidPairs >= p;
  }
}