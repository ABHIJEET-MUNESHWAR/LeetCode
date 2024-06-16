package com.leetcode.medium.graph;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/06/24,
 * Time:    10:21 am
 * 3015. Count the Number of Houses at a Certain Distance I
 * https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/description/
 */
public class CountOfPairs {
  public static void main(String[] args) {
    CountOfPairs countOfPairs = new CountOfPairs();
    int n = 5, x = 2, y = 4;
    ArrayUtils.printArray(countOfPairs.countOfPairs(n, x, y));
  }

  private int[] countOfPairs(int n, int x, int y) {
    int[] result = new int[n];
    int[][] graph = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(graph[i], Integer.MAX_VALUE);
    }
    for (int i = 1; i <= n; i++) {
      graph[i][i] = 0;
      if (i < n) {
        graph[i][i + 1] = 1;
      }
      if (i > 0) {
        graph[i][i - 1] = 1;
      }
    }
    graph[x][y] = 1;
    graph[y][x] = 1;
    for (int via = 1; via <= n; via++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (graph[i][via] != Integer.MAX_VALUE && graph[via][j] != Integer.MAX_VALUE) {
            graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
          }
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (graph[i][j] != Integer.MAX_VALUE && i != j) {
          result[graph[i][j] - 1]++;
        }
      }
    }
    return result;
  }
}