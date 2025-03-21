package com.leetcode.easy.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/07/24,
 * Time:    1:33 pm
 * 2133. Check if Every Row and Column Contains All Numbers
 * https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/description/
 */
public class CheckValid {
    public static void main(String[] args) {
        CheckValid checkValid = new CheckValid();
        int[][] matrix = {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
        System.out.println(checkValid.checkValid(matrix));
    }

    private boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int element = matrix[i][j];
                if (rowSet.contains(element)) {
                    return false;
                } else {
                    rowSet.add(element);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int element = matrix[j][i];
                if (colSet.contains(element)) {
                    return false;
                } else {
                    colSet.add(element);
                }
            }
        }
        return true;
    }
}