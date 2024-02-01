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
    int[][] grid = {{1, 2}, {2, 4}};
    ArrayUtils.printArray(findMissingAndRepeatedValues.findMissingAndRepeatedValues(grid));
  }

  private int[] findMissingAndRepeatedValues(int[][] grid) {
    long repeatedNo = 0;
    long missingNo = 0;
    long row = grid.length;
    long arraySum = 0;
    long arraySquareSum = 0;
    long arrayLength = row * row;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < row; j++) {
        arraySum += grid[i][j];
        arraySquareSum += (grid[i][j] * grid[i][j]);
      }
    }
    long sum = arrayLength * (arrayLength + 1) / 2;
    long squareSum = (arrayLength * (arrayLength + 1)) * (2 * arrayLength + 1) / 6;
    long diffOfSum = sum - arraySum;
    long diffOfSquareSum = squareSum - arraySquareSum;
    long sumOfSum = diffOfSquareSum / diffOfSum;
    repeatedNo = (sumOfSum - diffOfSum) / 2;
    missingNo = diffOfSum + repeatedNo;
    return new int[] {(int) repeatedNo, (int) missingNo};
  }
}