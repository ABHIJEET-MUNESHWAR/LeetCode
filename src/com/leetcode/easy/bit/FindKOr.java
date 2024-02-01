package com.leetcode.easy.bit;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/02/24,
 * Time:    8:48 am
 * https://leetcode.com/problems/find-the-k-or-of-an-array/
 */
public class FindKOr {
  public static void main(String[] args) {
    FindKOr findKOr = new FindKOr();
    int[] nums = {7, 12, 9, 8, 9, 15};
    int k = 4;
    System.out.println(findKOr.findKOr(nums, k));
  }

  private int findKOr(int[] nums, int k) {
    int answer = 0;
    int[] dp = new int[31];
    for (int num : nums) {
      int i = 0;
      while (num > 0) {
        if ((num & 1) == 1) {
          dp[i]++;
        }
        i++;
        num = num >> 1;
      }
    }
    for (int i = 0; i < 31; i++) {
      if (dp[i] >= k) {
        answer += 1 << i;
      }
    }
    return answer;
  }
}