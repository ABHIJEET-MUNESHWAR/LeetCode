package com.leetcode.medium.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/06/24,
 * Time:    9:06 am
 * 1926. Nearest Exit from Entrance in Maze
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
 */
public class NearestExit {
  public static void main(String[] args) {
    NearestExit nearestExit = new NearestExit();
    /*char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
    int[] entrance = {1, 2};*/
    char[][] maze = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
    int[] entrance = {1, 0};
    System.out.println(nearestExit.nearestExit(maze, entrance));
  }

  private int nearestExit(char[][] maze, int[] entrance) {
    int levels = 0;
    int rows = maze.length;
    int cols = maze[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(entrance);
    maze[entrance[0]][entrance[1]] = '+';
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] point = queue.poll();
        for (int[] direction : directions) {
          int nextX = point[0] + direction[0];
          int nextY = point[1] + direction[1];
          if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && maze[nextX][nextY] != '+') {
            if (nextX == 0 || nextX == rows - 1 || nextY == 0 || nextY == cols - 1) {
              return levels + 1;
            }
            maze[nextX][nextY] = '+';
            queue.add(new int[] {nextX, nextY});
          }
        }
      }
      levels++;
    }
    return -1;
  }
}