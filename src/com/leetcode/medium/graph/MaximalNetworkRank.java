package com.leetcode.medium.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/06/24,
 * Time:    8:51 am
 * 1615. Maximal Network Rank
 * https://leetcode.com/problems/maximal-network-rank/description/
 */
public class MaximalNetworkRank {
  public static void main(String[] args) {
    MaximalNetworkRank maximalNetworkRank = new MaximalNetworkRank();
    int n = 4;
    int[][] roads = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
    System.out.println(maximalNetworkRank.maximalNetworkRank(n, roads));
  }

  private int maximalNetworkRank(int n, int[][] roads) {
    int[] frequencyMap = new int[n];
    boolean[][] frequencyMatrix = new boolean[n][n];
    for (int[] road : roads) {
      frequencyMap[road[0]]++;
      frequencyMap[road[1]]++;
      frequencyMatrix[road[0]][road[1]] = true;
      frequencyMatrix[road[1]][road[0]] = true;
    }
    int maxRank = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int totalRank = frequencyMap[i] + frequencyMap[j];
        if (frequencyMatrix[i][j]) {
          totalRank--;
        }
        maxRank = Math.max(maxRank, totalRank);
      }
    }
    return maxRank;
  }
}