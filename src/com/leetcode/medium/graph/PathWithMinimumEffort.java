package com.leetcode.medium.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/06/24,
 * Time:    5:33 pm
 * 1631. Path With Minimum Effort
 * https://leetcode.com/problems/path-with-minimum-effort/description/
 */
public class PathWithMinimumEffort {
  public static void main(String[] args) {
    PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
    int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
    System.out.println(pathWithMinimumEffort.pathWithMinimumEffort(heights));
  }

  class Pair {
    int x;
    int y;
    int height;

    public Pair(int x, int y, int height) {
      this.x = x;
      this.y = y;
      this.height = height;
    }
  }

  private int pathWithMinimumEffort(int[][] heights) {
    int rows = heights.length;
    int columns = heights[0].length;
    int[][] efforts = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      Arrays.fill(efforts[i], Integer.MAX_VALUE);
    }
    PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.height - p2.height);
    pq.add(new Pair(0, 0, 0));
    efforts[0][0] = 0;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      int x = pair.x;
      int y = pair.y;
      int height = pair.height;
      if (x == rows - 1 && y == columns - 1) {
        return height;
      }
      for (int[] direction : directions) {
        int nextX = x + direction[0];
        int nextY = y + direction[1];
        if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < columns) {
          int newHeight = Math.max(height, Math.abs(heights[nextX][nextY] - heights[x][y]));
          if (efforts[nextX][nextY] > newHeight) {
            efforts[nextX][nextY] = newHeight;
            pq.add(new Pair(nextX, nextY, newHeight));
          }
        }
      }
    }
    return efforts[rows][columns];
  }
}