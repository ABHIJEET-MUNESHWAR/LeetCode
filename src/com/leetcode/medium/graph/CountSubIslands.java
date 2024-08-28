package com.leetcode.medium.graph;

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
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {1, 1, 0, 1, 1}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands.countSubIslands(grid1, grid2));
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