package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/02/23, Time:    7:56 am
 * https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
 */
public class CellsInRange {

  public static void main(String[] args) {
    CellsInRange cellsInRange = new CellsInRange();
    String s = "A1:F1";
    List<String> rangeList = cellsInRange.cellsInRange(s);
  }

  private List<String> cellsInRange(String s) {
    List<String> rangeList = new ArrayList<>();
    char colStart = s.charAt(0);
    char colEnd = s.charAt(3);
    int rowStart = Character.getNumericValue(s.charAt(1));
    int rowEnd = Character.getNumericValue(s.charAt(4));
    for (Character i = colStart; i <= colEnd; i++) {
      for (int j = rowStart; j <= rowEnd; j++) {
        rangeList.add(i + (j + "") + "");
      }
    }
    return rangeList;
  }
}