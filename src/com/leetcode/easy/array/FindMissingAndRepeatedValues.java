package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    31/01/24,
 * Time:    10:15 am
 * https://leetcode.com/problems/find-missing-and-repeated-values/
 */
public class FindMissingAndRepeatedValues {
  public static void main(String[] args) {
    FindMissingAndRepeatedValues findMissingAndRepeatedValues = new FindMissingAndRepeatedValues();
    int[][] grid = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
    ArrayUtils.printArray(findMissingAndRepeatedValues.findMissingAndRepeatedValues(grid));
  }

  private int[] findMissingAndRepeatedValues(int[][] grid) {
    int repeatedNo = 0;
    int row = grid.length;
    int arraySum = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < row; j++) {
        arraySum += grid[i][j];
        if (set.contains(grid[i][j])) {
          repeatedNo = grid[i][j];
        } else {
          set.add(grid[i][j]);
        }
      }
    }
    arraySum -= repeatedNo;
    int size = row * row;
    int totalSum = ((size) * (size + 1)) / 2;
    return new int[] {repeatedNo, totalSum - arraySum};
  }
}