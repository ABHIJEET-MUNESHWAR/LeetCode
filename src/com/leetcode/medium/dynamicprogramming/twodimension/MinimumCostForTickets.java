package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/06/24,
 * Time:    7:20 am
 * 983. Minimum Cost For Tickets
 * https://leetcode.com/problems/minimum-cost-for-tickets/description/
 */
public class MinimumCostForTickets {
  public static void main(String[] args) {
    MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();
    int[] days = {1, 4, 6, 7, 8, 20};
    int[] costs = {2, 7, 15};
    System.out.println(minimumCostForTickets.mincostTicketsRecursion(days, costs));
    System.out.println(minimumCostForTickets.mincostTicketsRecursionMemoization(days, costs));
    System.out.println(minimumCostForTickets.mincostTicketsBottomUp(days, costs));
  }

  private int mincostTicketsBottomUp(int[] days, int[] costs) {
    int totalDays = days.length;
    int lastDay = days[totalDays - 1];
    int[] dp = new int[lastDay + 1];
    boolean[] isTravelDayMap = new boolean[lastDay + 1];
    for (int day : days) {
      isTravelDayMap[day] = true;
    }
    dp[0] = 0;
    for (int i = 1; i <= lastDay; i++) {
      if (!isTravelDayMap[i]) { // no need to buy ticket if it is not a travel day
        dp[i] = dp[i - 1];
        continue;
      }
      int costOfOneDayPass = costs[0] + dp[Math.max(i - 1, 0)];
      int costOfSevenDayPass = costs[1] + dp[Math.max(i - 7, 0)];
      int costOfThirtyDayPass = costs[2] + dp[Math.max(i - 30, 0)];
      dp[i] = Math.min(costOfOneDayPass, Math.min(costOfSevenDayPass, costOfThirtyDayPass));
    }
    return dp[lastDay];
  }

  int[] dp;

  private int mincostTicketsRecursionMemoization(int[] days, int[] costs) {
    dp = new int[days.length + 1];
    Arrays.fill(dp, -1);
    return solveRecursionMemoization(days, costs, 0);
  }

  private int solveRecursionMemoization(int[] days, int[] costs, int index) {
    if (index >= days.length) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    int costOfOneDayPass = costs[0] + solveRecursionMemoization(days, costs, index + 1);
    int costOfSevenDayPass = costs[1] + solveRecursionMemoization(days, costs, getIndexOfNextDay(days, index, days[index] + 7));
    int costOfThirtyDayPass = costs[2] + solveRecursionMemoization(days, costs, getIndexOfNextDay(days, index, days[index] + 30));
    return dp[index] = Math.min(costOfOneDayPass, Math.min(costOfSevenDayPass, costOfThirtyDayPass));
  }

  private int mincostTicketsRecursion(int[] days, int[] costs) {
    return solveRecursion(days, costs, 0);
  }

  private int solveRecursion(int[] days, int[] costs, int index) {
    if (index >= days.length) {
      return 0;
    }
    int costOfOneDayPass = costs[0] + solveRecursion(days, costs, index + 1);
    int costOfSevenDayPass = costs[1] + solveRecursion(days, costs, getIndexOfNextDay(days, index, days[index] + 7));
    int costOfThirtyDayPass = costs[2] + solveRecursion(days, costs, getIndexOfNextDay(days, index, days[index] + 30));
    return Math.min(costOfOneDayPass, Math.min(costOfSevenDayPass, costOfThirtyDayPass));
  }

  private int getIndexOfNextDay(int[] days, int index, int totalDaysCanBeCovered) {
    while (index < days.length && days[index] < totalDaysCanBeCovered) {
      index++;
    }
    return index;
  }
}