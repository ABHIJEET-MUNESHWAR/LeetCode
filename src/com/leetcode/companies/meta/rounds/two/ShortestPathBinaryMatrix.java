package com.leetcode.companies.meta.rounds.two;

import java.util.*;

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
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    class Cell {
        int row;
        int col;
        List<int[]> path;

        public Cell(int row, int col, List<int[]> path) {
            this.row = row;
            this.col = col;
            this.path = new ArrayList<>(path);
            this.path.add(new int[]{row, col});
        }
    }

    private int shortestPathBinaryMatrixBFS(int[][] grid) {
        int n = grid.length;
        if (n == 0 || grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<Cell> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        queue.add(new Cell(0, 0, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();
            int row = currentCell.row;
            int col = currentCell.col;
            if (row == n - 1 && col == n - 1) {
                printPath(currentCell.path);
                return currentCell.path.size();
            }
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (isValid(grid, newRow, newCol, visited)) {
                    visited[newRow][newCol] = true;
                    queue.add(new Cell(newRow, newCol, currentCell.path));
                }
            }
        }
        return -1;
    }

    private boolean isValid(int[][] grid, int newRow, int newCol, boolean[][] visited) {
        return newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && !visited[newRow][newCol] && grid[newRow][newCol] == 0;
    }

    private void printPath(List<int[]> path) {
        System.out.println("Shortest Path: ");
        for (int[] cell : path) {
            System.out.println(Arrays.toString(cell));
        }
    }
}