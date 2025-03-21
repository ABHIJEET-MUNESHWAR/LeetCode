package com.leetcode.medium.dynamicprogramming.onedimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/08/24,
 * Time:    10:52 pm
 * 650. 2 Keys Keyboard
 * https://leetcode.com/problems/2-keys-keyboard/description/
 */
public class MinSteps {
    public static void main(String[] args) {
        MinSteps minSteps = new MinSteps();
        int n = 3;
        System.out.println(minSteps.minStepsRecursion(n));
        System.out.println(minSteps.minStepsRecursionMemoization(n));
    }

    int[][] dp;

    private int minStepsRecursionMemoization(int n) {
        if (n == 1) {
            return 0; // We already have 1 A in the notepad
        }
        dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        return 1 + minStepsRecursionMemoization(n, 1, 1);
    }

    private int minStepsRecursionMemoization(int n, int currentA, int clipboardA) {
        if (currentA == n) {
            return 0;
        }
        if (currentA > n) {
            return 1000000;
        }
        if (dp[currentA][clipboardA] != -1) {
            return dp[currentA][clipboardA];
        }
        int copyAllPaste = 1 + 1 + minStepsRecursionMemoization(n, currentA + currentA, currentA);
        int paste = 1 + minStepsRecursionMemoization(n, currentA + clipboardA, clipboardA);
        return dp[currentA][clipboardA] = Math.min(copyAllPaste, paste);
    }

    private int minStepsRecursion(int n) {
        if (n == 1) {
            return 0; // We already have 1 A in the notepad
        }
        return 1 + recursiveSolve(n, 1, 1);
    }

    private int recursiveSolve(int n, int currentA, int clipboardA) {
        if (currentA == n) {
            return 0;
        }
        if (currentA > n) {
            return 1000000;
        }
        int copyAllPaste = 1 + 1 + recursiveSolve(n, currentA + currentA, currentA);
        int paste = 1 + recursiveSolve(n, currentA + clipboardA, clipboardA);
        return Math.min(copyAllPaste, paste);
    }
}