package com.leetcode.medium.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/06/24,
 * Time:    8:40 pm
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/description/
 */
public class RottingOranges {
  public static void main(String[] args) {
    RottingOranges rottingOranges = new RottingOranges();
    int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.out.println(rottingOranges.orangesRotting(grid));
  }

  class Pair {
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time) {
      this.row = row;
      this.col = col;
      this.time = time;
    }
  }

  private int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] visited = new int[m][n];
    Queue<Pair> queue = new LinkedList<>();
    int freshOrangesCount = 0;
    int rottenOrangesCount = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // if cell contains rotten orange
        if (grid[i][j] == 2) {
          queue.add(new Pair(i, j, 0));
          // mark as visited (rotten) in visited array
          visited[i][j] = 2;
        } else {
          // if not rotten
          visited[i][j] = 0;
        }
        // count fresh oranges
        if (grid[i][j] == 1) {
          freshOrangesCount++;
        }
      }
    }
    int time = 0;
    // delta row and delta column
    int drow[] = {-1, 0, +1, 0};
    int dcol[] = {0, 1, 0, -1};
    // until the queue becomes empty
    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int r = pair.row;
      int c = pair.col;
      int t = pair.time;
      time = Math.max(time, t);
      // exactly 4 neighbours
      for (int i = 0; i < 4; i++) {
        int nrow = r + drow[i];
        int ncol = c + dcol[i];
        // check for valid coordinates and
        // then for unvisited fresh orange
        if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
          // push in queue with timer increased
          queue.add(new Pair(nrow, ncol, t + 1));
          // mark as rotten
          visited[nrow][ncol] = 2;
          rottenOrangesCount++;
        }
      }
    }
    if (freshOrangesCount != rottenOrangesCount) {
      return -1;
    }
    return time;
  }
}