package com.leetcode.medium.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/08/24,
 * Time:    12:20 am
 * 1905. Count Sub Islands
 * https://leetcode.com/problems/count-sub-islands/description/
 */
public class CountSubIslands {
    public static void main(String[] args) {
        CountSubIslands countSubIslands = new CountSubIslands();
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands.countSubIslands(grid1, grid2));
        System.out.println(countSubIslands.countSubIslandsUsingDFS(grid1, grid2));
        System.out.println(countSubIslands.countSubIslandsUsingBFS(grid1, grid2));
    }

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int countSubIslandsUsingBFS(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        int m = grid2.length; // rows
        int n = grid2[0].length; // cols

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && checkSubIslandBFS(grid1, grid2, i, j)) { // Found an island
                    subIslands++;
                }
            }
        }

        return subIslands;
    }

    private boolean checkSubIslandBFS(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;

        boolean result = true;

        Queue<int[]> queue = new LinkedList<>(); // Queue to perform BFS
        queue.offer(new int[] {i, j});
        grid2[i][j] = -1; // mark visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (grid1[x][y] != 1) { // grid1 must have 1 at the same coordinate
                result = false;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid2[newX][newY] == 1) {
                    grid2[newX][newY] = -1; // mark visited
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        return result;

    }

    private int countSubIslandsUsingDFS(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int subIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && checkSubIslandDfs(grid1, grid2, i, j)) {
                    subIslands++;
                }
            }
        }
        return subIslands;
    }

    private boolean checkSubIslandDfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return true;
        }

        if (grid2[i][j] != 1) { // we only need to check land (grid2[i][j] == 1)
            return true;
        }

        grid2[i][j] = -1; // mark visited

        boolean result = (grid1[i][j] == 1); // grid1[i][j] must have 1 to be a sub-island

        // Perform DFS in all four directions (down, up, right, left)
        result = result & checkSubIslandDfs(grid1, grid2, i + 1, j); // Down
        result = result & checkSubIslandDfs(grid1, grid2, i - 1, j); // Up
        result = result & checkSubIslandDfs(grid1, grid2, i, j + 1); // Right
        result = result & checkSubIslandDfs(grid1, grid2, i, j - 1); // Left

        return result;
    }

    private int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    result += dfs(grid1, grid2, i, j);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;
        int result = 1;
        if (i < 0 || i == m || j < 0 || j == n || grid2[i][j] == 0) {
            return 1;
        }
        grid2[i][j] = 0;
        result &= dfs(grid1, grid2, i - 1, j);
        result &= dfs(grid1, grid2, i + 1, j);
        result &= dfs(grid1, grid2, i, j - 1);
        result &= dfs(grid1, grid2, i, j + 1);
        return result & grid1[i][j];
    }
}