package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    31/08/22, Time:    6:48 PM
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelColumnNumber {

  public static void main(String[] args) {
    ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();
    System.out.println(excelColumnNumber.titleToNumber("ZY"));
  }

  private int titleToNumber(String columnTitle) {
    int sum = 0;
    if (columnTitle == null) {
      return sum;
    }
    for (char ch : columnTitle.toUpperCase().toCharArray()) {
      sum *= 26;
      sum += ch - 'A' + 1;
    }
    return sum;
  }
}