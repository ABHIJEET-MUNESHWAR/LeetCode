package com.leetcode.medium.dynamicprogramming;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/08/24,
 * Time:    7:55 am
 * 1105. Filling Bookcase Shelves
 * https://leetcode.com/problems/filling-bookcase-shelves/description/?envType=daily-question&envId=2024-07-31
 */
public class FillingBookcaseShelves {
    public static void main(String[] args) {
        FillingBookcaseShelves fillingBookcaseShelves = new FillingBookcaseShelves();
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth = 4;
        System.out.println(fillingBookcaseShelves.minHeightShelvesRecursion(books, shelfWidth));
        System.out.println(fillingBookcaseShelves.minHeightShelvesMemoization(books, shelfWidth));
    }

    int totalShelfWidth;
    int[][] dp;

    private int minHeightShelvesMemoization(int[][] books, int shelfWidth) {
        int index = 0;
        int maxHeight = 0;
        totalShelfWidth = shelfWidth;
        dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveMemoization(books, shelfWidth, index, maxHeight);
    }

    private int solveMemoization(int[][] books, int remainingWidth, int index, int maxHeight) {
        if (index >= books.length) {
            return maxHeight;
        }

        if (dp[index][remainingWidth] != -1) {
            return dp[index][remainingWidth];
        }

        int width = books[index][0];
        int height = books[index][1];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        // keep
        if (width <= remainingWidth) {
            keep = solveMemoization(books, remainingWidth - width, index + 1, Math.max(maxHeight, height));
        }

        // skip and put in next shelf
        skip = maxHeight + solveMemoization(books, totalShelfWidth - width, index + 1, height);
        return dp[index][remainingWidth] = Math.min(keep, skip);
    }


    private int minHeightShelvesRecursion(int[][] books, int shelfWidth) {
        int index = 0;
        int maxHeight = 0;
        totalShelfWidth = shelfWidth;
        return solveRecursion(books, shelfWidth, index, maxHeight);
    }

    private int solveRecursion(int[][] books, int remainingWidth, int index, int maxHeight) {
        if (index >= books.length) {
            return maxHeight;
        }

        int width = books[index][0];
        int height = books[index][1];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        // keep
        if (width <= remainingWidth) {
            keep = solveRecursion(books, remainingWidth - width, index + 1, Math.max(maxHeight, height));
        }

        // skip and put in next shelf
        skip = maxHeight + solveRecursion(books, totalShelfWidth - width, index + 1, height);

        return Math.min(keep, skip);
    }
}