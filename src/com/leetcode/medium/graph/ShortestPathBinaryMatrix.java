package com.leetcode.medium.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/06/24,
 * Time:    9:08 pm
 * 1091. Shortest Path in Binary Matrix
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 */
public class ShortestPathBinaryMatrix {
  public static void main(String[] args) {
    ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
    int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
    System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrixBFS(grid));
    System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrixDijkstra(grid));
  }

  class Pair {
    int x;
    int y;
    int distance;

    public Pair(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }
  }

  private int shortestPathBinaryMatrixDijkstra(int[][] grid) {
    int n = grid.length;
    boolean[][] visited = new boolean[n][n];
    if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
      return -1;
    }
    Pair pair = new Pair(0, 0, 1);
    visited[0][0] = true;
    PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2) -> p1.distance - p2.distance);
    pq.add(pair);
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};
    while (!pq.isEmpty()) {
      Pair p = pq.poll();
      int x = p.x;
      int y = p.y;
      int distance = p.distance;
      if (x == n - 1 && y == n - 1) {
        return distance;
      }
      for (int[] direction : directions) {
        int nextX = x + direction[0];
        int nextY = y + direction[1];
        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY] || grid[nextX][nextY] == 1) {
          continue;
        }
        visited[nextX][nextY] = true;
        Pair nextPair = new Pair(nextX, nextY, distance + 1);
        pq.add(nextPair);
      }
    }
    return -1;
  }

  private int shortestPathBinaryMatrixBFS(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }
    int answer = 0;
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] visited = new boolean[row][col];
    if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
      return -1;
    }
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0});
    visited[0][0] = true;
    while (!queue.isEmpty()) {
      answer++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] currentPosition = queue.poll();
        if (currentPosition[0] == row - 1 && currentPosition[1] == col - 1) {
          return answer;
        }
        for (int[] direction : directions) {
          int nextX = currentPosition[0] + direction[0];
          int nextY = currentPosition[1] + direction[1];
          if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY] || grid[nextX][nextY] == 1) {
            continue;
          }
          visited[nextX][nextY] = true;
          queue.add(new int[] {nextX, nextY});
        }
      }
    }
    return -1;
  }
}