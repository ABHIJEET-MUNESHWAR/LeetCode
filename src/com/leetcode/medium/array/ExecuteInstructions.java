package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/05/24,
 * Time:    8:16 am
 * 2120. Execution of All Suffix Instructions Staying in a Grid
 * https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/description/
 */
public class ExecuteInstructions {
  public static void main(String[] args) {
    ExecuteInstructions executeInstructions = new ExecuteInstructions();
    int n = 3;
    int[] startPos = {0, 1};
    String s = "RRDDLU";
    ArrayUtils.printArray(executeInstructions.executeInstructions(n, startPos, s));
  }

  private int[] executeInstructions(int n, int[] startPos, String s) {
    int stepsLength = s.length();
    int[] result = new int[stepsLength];
    for (int i = 0; i < stepsLength; i++) {
      int currentRow = startPos[0];
      int currentCol = startPos[1];
      int totalMoves = 0;
      for (int j = i; j < stepsLength; j++) {
        char currentMove = s.charAt(j);
        switch (currentMove) {
          case 'R':
            currentCol++;
            break;
          case 'L':
            currentCol--;
            break;
          case 'U':
            currentRow--;
            break;
          case 'D':
            currentRow++;
            break;
        }
        if (currentCol < 0 || currentCol >= n || currentRow < 0 || currentRow >= n) {
          break;
        } else {
          totalMoves++;
        }
      }
      result[i] = totalMoves;
    }
    return result;
  }
}