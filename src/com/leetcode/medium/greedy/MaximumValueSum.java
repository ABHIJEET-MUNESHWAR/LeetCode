package com.leetcode.medium.greedy;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/05/24,
 * Time:    10:15 pm
 * 3068. Find the Maximum Sum of Node Values
 * https://leetcode.com/problems/find-the-maximum-sum-of-node-values/description/?envType=daily-question&envId=2024-05-19
 */
public class MaximumValueSum {
  public static void main(String[] args) {
    MaximumValueSum maximumValueSum = new MaximumValueSum();
    int[] nums = {1, 2, 1};
    int k = 3;
    int[][] edges = {{0, 1}, {0, 2}};
    System.out.println(maximumValueSum.maximumValueSum(nums, k, edges));
  }

  private long maximumValueSum(int[] nums, int k, int[][] edges) {
    long minimumLoss = Integer.MAX_VALUE;
    long idealSum = 0;
    long count = 0;
    for (int num : nums) {
      if ((num ^ k) > num) {
        count++;
        idealSum += (num ^ k);
      } else {
        idealSum += num;
      }
      minimumLoss = Math.min(minimumLoss, Math.abs(num - ((num ^ k))));
    }
    if (count % 2 == 0) {
      return idealSum;
    }
    return idealSum - minimumLoss;
  }
}