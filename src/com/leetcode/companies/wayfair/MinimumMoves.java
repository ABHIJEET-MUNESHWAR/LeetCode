package com.leetcode.companies.wayfair;

import java.util.LinkedList;
import java.util.Queue;

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
        int[][] maze = new int[][] {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int n = 3, m = 3, k = 2;
        minimumMoves.minimumMovesRecursionDfs(maze, m, n, k);
        System.out.println(minimumMoves.minimumMovesRecursionBfs(maze, m, n, k));
    }

    private int minimumMovesRecursionBfs(int[][] matrix, int m, int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = -1;
            }
        }
        distance[0][0] = 1;
        if (matrix[0][0] == 1) {
            return -1;
        }
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            matrix[parent[0]][parent[1]] = 2;
            for (int[] direction : directions) {
                for (int jump = 1; jump <= k; jump++) {
                    int newX = parent[0] + direction[0] * jump;
                    int newY = parent[1] + direction[1] * jump;
                    if (isValid(newX, newY, m, n) && matrix[newX][newY] == 0) {
                        queue.add(new int[] {newX, newY});
                        matrix[newX][newY] = 2;
                        distance[newX][newY] = distance[parent[0]][parent[1]] + jump;
                    }
                }
            }
        }
        return distance[m - 1][n - 1];
    }

    private boolean isValid(int newX, int newY, int m, int n) {
        return (newX >= 0 && newX < m && newY >= 0 && newY < n);
    }

    private void minimumMovesRecursionDfs(int[][] maze, int m, int n, int k) {
        int[][] visited = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        int i = 0, j = 0;
        shortestPathToEnd(maze, m, n, k, visited, i, j, 0);
        System.out.println(minSteps);
    }

    int minSteps = Integer.MAX_VALUE;

    private void shortestPathToEnd(int[][] maze, int m, int n, int k, int[][] visited, int i, int j, int steps) {
        if (i == m - 1 && j == n - 1) {
            minSteps = Math.min(minSteps, steps);
            visited[i][j] = minSteps;
            return;
        }
        visited[i][j] = steps;
        for (int x = 1; x <= k; x++) {
            steps++;
            if (isSafe(maze, m, n, k, visited, i + k, j, steps)) {
                shortestPathToEnd(maze, m, n, k, visited, i + k, j, steps);
            }
            if (isSafe(maze, m, n, k, visited, i - k, j, steps)) {
                shortestPathToEnd(maze, m, n, k, visited, i - k, j, steps);
            }
            if (isSafe(maze, m, n, k, visited, i, j + k, steps)) {
                shortestPathToEnd(maze, m, n, k, visited, i, j + k, steps);
            }
            if (isSafe(maze, m, n, k, visited, i, j - k, steps)) {
                shortestPathToEnd(maze, m, n, k, visited, i, j - k, steps);
            }
        }
    }

    private boolean isSafe(int[][] maze, int m, int n, int k, int[][] visited, int i, int j, int steps) {
        return (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1 && steps < visited[i][j]);
    }
}