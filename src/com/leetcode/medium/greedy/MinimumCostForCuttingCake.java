package com.leetcode.medium.greedy;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/07/24,
 * Time:    12:20 pm
 * 3218. Minimum Cost for Cutting Cake I
 * https://leetcode.com/problems/minimum-cost-for-cutting-cake-i/description/
 */
public class MinimumCostForCuttingCake {
    public static void main(String[] args) {
        MinimumCostForCuttingCake solution = new MinimumCostForCuttingCake();
        int m = 3, n = 2;
        int[] horizontalCut = {1, 3};
        int[] verticalCut = {5};
        System.out.println(solution.minimumCost(m, n, horizontalCut, verticalCut));
    }

    private int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int result = 0;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int colCount = 1, rowCount = 1;
        int i = m - 2, j = n - 2;
        while (i >= 0 && j >= 0) {
            if (horizontalCut[i] > verticalCut[j]) {
                result += horizontalCut[i] * colCount;
                rowCount++;
                i--;
            } else {
                result += verticalCut[j] * rowCount;
                colCount++;
                j--;
            }
        }
        while (i >= 0) {
            result += horizontalCut[i] * colCount;
            rowCount++;
            i--;
        }
        while (j >= 0) {
            result += verticalCut[j] * rowCount;
            colCount++;
            j--;
        }
        return result;
    }
}