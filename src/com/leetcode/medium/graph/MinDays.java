package com.leetcode.medium.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/08/24,
 * Time:    6:57 pm
 * 1568. Minimum Number of Days to Disconnect Island
 * https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/description/
 */
public class MinDays {
    public static void main(String[] args) {
        MinDays minDays = new MinDays();
        int[][] grid = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(minDays.minDays(grid));
    }

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = numberOfIslands(grid);
        if (islands == 0 || islands > 1) {
            return 0;
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        islands = numberOfIslands(grid);
                        grid[i][j] = 1;
                        if (islands > 1 || islands == 0) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 2;
    }

    private int numberOfIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && (grid[i][j] == 1)) {
                    dfs(grid, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            dfs(grid, x, y, visited);
        }
    }
}