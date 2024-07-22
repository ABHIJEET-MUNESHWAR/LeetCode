package com.leetcode.contest.companies.wayfair;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/07/24,
 * Time:    10:18 pm
 * MinimumMoves
 * https://leetcode.com/discuss/interview-question/5505127/Wayfair-Software-Engineer-II-OA
 */
public class MinimumMoves {
    public static void main(String[] args) {
        MinimumMoves minimumMoves = new MinimumMoves();
        int[][] maze = new int[][] {{0, 0}, {1, 0}};
        int n = 2, m = 2, k = 2;
        System.out.println(minimumMoves.minimumMovesRecursion(maze, m, n, k));
    }

    private int minimumMovesRecursion(int[][] maze, int m, int n, int k) {
        return solve(maze, m, n, k, 0, 0);
    }

    private int solve(int[][] maze, int m, int n, int k, int i, int j) {
        if ((i == m - 1) && (j == n - 1)) {
            return 1;
        }
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        return 1 + Math.min(solve(maze, m, n, k, i + k, j), solve(maze, m, n, k, i, j + k));
    }
}