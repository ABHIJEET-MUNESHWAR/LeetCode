package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    18/09/23,
 * Time:    9:13 am
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/?envType=daily-question&envId=2023-09-18
 */
public class KWeakestRows {
  public static void main(String[] args) {
    KWeakestRows kWeakestRows = new KWeakestRows();
    int[][] mat =
        {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
    int k = 3;
    ArrayUtils.printArray(kWeakestRows.kWeakestRows(mat, k));
  }

  private int[] kWeakestRows(int[][] mat, int k) {
    int row = mat.length;
    int col = mat[0].length;
    int[] array = new int[row];
    for (int i = 0; i < row; i++) {
      int count = 0;
      for (int j = 0; j < col; j++) {
        if (mat[i][j] == 1) {
          count++;
        }
      }
      array[i] = count;
    }
    int[] answer = new int[k];
    for (int i = 0; i < k; i++) {
      int l = 0;
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < array.length; j++) {
        if (array[j] < min) {
          min = array[j];
          l = j;
        }
      }
      answer[i] = l;
      array[l] = Integer.MAX_VALUE;
    }
    Arrays.sort(array);
    return answer;
  }
}