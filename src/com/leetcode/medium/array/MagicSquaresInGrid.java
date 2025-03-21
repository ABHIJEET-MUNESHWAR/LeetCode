package com.leetcode.medium.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/08/24,
 * Time:    9:02 pm
 * 840. Magic Squares In Grid
 * https://leetcode.com/problems/magic-squares-in-grid/description/
 */
public class MagicSquaresInGrid {
    public static void main(String[] args) {
        MagicSquaresInGrid magicSquaresInGrid = new MagicSquaresInGrid();
        int[][] grid = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        System.out.println(magicSquaresInGrid.numMagicSquaresInside(grid));
    }

    private int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagicGrid(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicGrid(int[][] grid, int r, int c) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[r + i][c + j];
                if (set.contains(num) || num < 1 || num > 9) {
                    return false;
                } else {
                    set.add(num);
                }
            }
        }
        // Check the sum for rows and columns
        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];

        // Check row sum and column sum
        for (int i = 0; i < 3; i++) {
            if ((grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2]) != sum) {
                return false;
            }
            if ((grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i]) != sum) {
                return false;
            }
        }

        // Check diagonal and anti-diagonal sum
        if ((grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]) != sum) {
            return false;
        }
        if ((grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]) != sum) {
            return false;
        }
        return true;
    }
}