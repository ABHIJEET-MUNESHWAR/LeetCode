package com.leetcode.hard.dynamicprogramming;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/08/24,
 * Time:    8:49 am
 * 664. Strange Printer
 * https://leetcode.com/problems/strange-printer/description/
 */
public class StrangePrinter {
    public static void main(String[] args) {
        StrangePrinter strangePrinter = new StrangePrinter();
        String s = "aaabbb";
        System.out.println(strangePrinter.strangePrinterRecursion(s));
        System.out.println(strangePrinter.strangePrinterRecursionMemoization(s));
    }

    int[][] dp;

    private int strangePrinterRecursionMemoization(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecursionMemoization(s, left, right);
    }

    private int solveRecursionMemoization(String s, int left, int right) {
        if (left == right) {
            return 1;
        }
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int i = left + 1;
        while (i <= right && s.charAt(i) == s.charAt(left)) {
            i++;
        }
        if (i == right + 1) {
            return 1;
        }
        int normal = 1 + solveRecursionMemoization(s, i, right);
        int greedy = Integer.MAX_VALUE;
        for (int j = i; j <= right; j++) {
            if (s.charAt(j) == s.charAt(left)) {
                int x = solveRecursionMemoization(s, i, j - 1) + solveRecursionMemoization(s, j, right);
                greedy = Math.min(greedy, x);
            }
        }
        return dp[left][right] = Math.min(greedy, normal);
    }

    private int strangePrinterRecursion(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        return solveRecursion(s, left, right);
    }

    private int solveRecursion(String s, int left, int right) {
        if (left == right) {
            return 1;
        }
        if (left > right) {
            return 0;
        }
        int i = left + 1;
        while (i <= right && s.charAt(i) == s.charAt(left)) {
            i++;
        }
        if (i == right + 1) {
            return 1;
        }
        int normal = 1 + solveRecursion(s, i, right);
        int greedy = Integer.MAX_VALUE;
        for (int j = i; j <= right; j++) {
            if (s.charAt(j) == s.charAt(left)) {
                int x = solveRecursion(s, i, j - 1) + solveRecursion(s, j, right);
                greedy = Math.min(greedy, x);
            }
        }
        return Math.min(greedy, normal);
    }
}