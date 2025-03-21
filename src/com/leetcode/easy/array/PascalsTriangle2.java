package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    30/08/22, Time:    10:00 AM
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangle2 {

  public static void main(String[] args) {
    PascalsTriangle2 pascalsTriangle2 = new PascalsTriangle2();
    System.out.println(pascalsTriangle2.getRow2(3));
    System.out.println(pascalsTriangle2.getRow(3));
  }

  private List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<>();
    if (rowIndex < 0) {
      return row;
    }
    for (int i = 0; i <= rowIndex; i++) {
      row.add(0, 1);
      for (int j = 1; j < row.size() - 1; j++) {
        row.set(j, row.get(j) + row.get(j + 1));
      }
    }
    return row;
  }

  private List<Integer> getRow2(int rowIndex) {
    List<List<Integer>> rows = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          List<Integer> prevRow = rows.get(i - 1);
          row.add(prevRow.get(j) + prevRow.get(j - 1));
        }
      }
      rows.add(row);
    }
    return rows.get(rowIndex);
  }
}