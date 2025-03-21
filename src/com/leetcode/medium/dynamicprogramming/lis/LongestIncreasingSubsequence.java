package com.leetcode.medium.dynamicprogramming.lis;

import java.util.ArrayList;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/05/24,
 * Time:    8:31 pm
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSubsequence {
  public static void main(String[] args) {
    LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    System.out.println(longestIncreasingSubsequence.lengthOfLISBottomUp(nums));
    System.out.println(longestIncreasingSubsequence.lengthOfLISBinarySearch(nums));
  }

  private int lengthOfLISBinarySearch(int[] nums) {
    int n = nums.length;

    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(nums[0]);
    for (int i = 1; i < n; i++) {
      if (nums[i] > arr.get(arr.size() - 1)) {
        arr.add(nums[i]);
      } else {
        int l = 0, r = arr.size() - 1, ans = 0;
        while (l <= r) {
          int mid = (l + r) / 2;

          if (nums[i] <= arr.get(mid)) {
            ans = mid;
            r = mid - 1;
          } else {
            l = mid + 1;
          }
        }
        arr.set(ans, nums[i]);
      }
    }
    return arr.size();
  }


  private int lengthOfLISBottomUp(int[] nums) {
    int[] dp = new int[2501];
    for (int i = 0; i < 2501; i++) {
      dp[i] = 1;
    }
    int size = nums.length;
    int maxLIS = 1;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          maxLIS = Math.max(maxLIS, dp[i]);
        }
      }
    }
    return maxLIS;
  }

  int size;
  int[][] dp = new int[2501][2501];

  private int lengthOfLIS(int[] nums) {
    size = nums.length;
    for (int i = 0; i < 2501; i++) {
      for (int j = 0; j < 2501; j++) {
        dp[i][j] = -1;
      }
    }
    return solve(nums, 0, -1);
  }

  private int solve(int[] nums, int index, int previous) {
    if (previous != -1 && dp[index][previous] != -1) {
      return dp[index][previous];
    }
    if (index >= size) {
      return 0;
    }
    int take = 0;
    if (previous == -1 || nums[previous] < nums[index]) {
      take = 1 + solve(nums, index + 1, index);
    }
    int skip = solve(nums, index + 1, previous);
    if (previous != -1) {
      dp[index][previous] = Math.max(take, skip);
    }
    return Math.max(take, skip);
  }
}