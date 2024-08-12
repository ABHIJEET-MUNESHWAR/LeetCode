package com.leetcode.medium.simulation;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/08/24,
 * Time:    8:21 pm
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrixOne {
    public static void main(String[] args) {
        SpiralMatrixOne spiralMatrixOne = new SpiralMatrixOne();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ListUtils.printList(spiralMatrixOne.spiralOrder(matrix));
    }

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int direction = 0;
        /*
            direction: -> 0: Left to Right
            direction: -> 1: Top to Bottom
            direction: -> 2: Right to Left
            direction: -> 3: Bottom to Top
         */
        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
            }
            if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            }
            if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return list;
    }
}