package com.leetcode.easy.dynamicprogramming;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/05/24,
 * Time:    11:22 am
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class MinCostClimbingStairs {
  int[] dp = new int[10001];

  public static void main(String[] args) {
    MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
    int[] cost = {10, 15, 20};
    System.out.println(minCostClimbingStairs.minCostClimbingStairsDpMemorisation(cost));
    System.out.println(minCostClimbingStairs.minCostClimbingStairsBottomUp(cost));
  }

  private int minCostClimbingStairsBottomUp(int[] cost) {
    int size = cost.length;
    for (int i = 2; i < size; i++) {
      cost[i] += Math.min(cost[i - 1], cost[i - 2]);
    }
    return Math.min(cost[size - 1], cost[size - 2]);
  }

  private int minCostClimbingStairsDpMemorisation(int[] cost) {
    for (int i = 0; i < 10001; i++) {
      dp[i] = -1;
    }
    return Math.min(solve(cost, 0), solve(cost, 1));
  }

  private int solve(int[] cost, int i) {
    if (i >= cost.length) {
      return 0;
    }
    if (dp[i] != -1) {
      return dp[i];
    }
    int a = cost[i] + solve(cost, i + 1);
    int b = cost[i] + solve(cost, i + 2);
    dp[i] = Math.min(a, b);
    return dp[i];
  }
}