package com.leetcode.medium.graph;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/06/24,
 * Time:    2:32 pm
 * 2285. Maximum Total Importance of Roads
 * https://leetcode.com/problems/maximum-total-importance-of-roads/description/?envType=daily-question&envId=2024-06-28
 */
public class MaximumTotalImportanceOfRoads {
  public static void main(String[] args) {
    MaximumTotalImportanceOfRoads maximumTotalImportanceOfRoads = new MaximumTotalImportanceOfRoads();
    int n = 5;
    int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
    System.out.println(maximumTotalImportanceOfRoads.maximumImportance(n, roads));
  }

  private long maximumImportance(int n, int[][] roads) {
    int[] degree = new int[n];
    for (int[] road : roads) {
      degree[road[0]]++;
      degree[road[1]]++;
    }
    Arrays.sort(degree);
    long sum = 0;
    long value = 1;
    for (int i = 0; i < n; i++) {
      sum += (degree[i] * value);
      value++;
    }
    return sum;
  }
}