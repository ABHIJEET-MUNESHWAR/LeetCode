package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/04/24,
 * Time:    9:15 am
 */
public class FindAllGroupsOfFarmland {
  public static void main(String[] args) {
    FindAllGroupsOfFarmland findAllGroupsOfFarmland = new FindAllGroupsOfFarmland();
    int[][] land = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
    ArrayUtils.printMatrix(findAllGroupsOfFarmland.findFarmland(land));
  }

  private int[][] findFarmland(int[][] land) {
    List<int[]> resultList = new ArrayList<>();
    int rows = land.length;
    int cols = land[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if ((land[i][j] == 1)
            && (i == 0 || land[i - 1][j] == 0)
            && (j == 0 || land[i][j - 1] == 0)) {
          int i2 = i, j2 = j;
          while (i2 < rows && land[i2][j] == 1) {
            i2++;
          }
          while (j2 < cols && land[i][j2] == 1) {
            j2++;
          }
          resultList.add(new int[] {i, j, i2 - 1, j2 - 1});
        }
      }
    }
    return resultList.toArray(new int[0][]);
  }
}