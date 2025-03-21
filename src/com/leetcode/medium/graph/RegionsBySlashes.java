package com.leetcode.medium.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/08/24,
 * Time:    7:54 pm
 * 959. Regions Cut By Slashes
 * https://leetcode.com/problems/regions-cut-by-slashes/description/
 */
public class RegionsBySlashes {
    public static void main(String[] args) {
        RegionsBySlashes regionsBySlashes = new RegionsBySlashes();
        String[] grid = {"/\\", "\\/"};
        System.out.println(regionsBySlashes.regionsBySlashes(grid));
    }

    private int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        int regions = 0;
        int[][] matrix = new int[rows * 3][cols * 3];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == '/') {
                    matrix[i * 3][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    matrix[i * 3][j * 3] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    numberOfIslandsDFS(matrix, i, j);
                    regions++;
                }
            }
        }
        return regions;
    }

    private void numberOfIslandsDFS(int[][] matrix, int i, int j) {
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] == 1) {
            return;
        }
        matrix[i][j] = 1;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            numberOfIslandsDFS(matrix, newI, newJ);
        }
    }
}