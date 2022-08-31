package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    31/08/22, Time:    3:29 PM
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelColumnTitle {

  public static void main(String[] args) {
    ExcelColumnTitle excelColumnTitle = new ExcelColumnTitle();
    System.out.println(excelColumnTitle.convertToTitle(1));
    System.out.println(excelColumnTitle.convertToTitle(28));
    System.out.println(excelColumnTitle.convertToTitle(701));
    System.out.println(excelColumnTitle.convertToTitle(702));
  }

  private String convertToTitle(int columnNumber) {
    String title = "";
    while (columnNumber > 0) {
      columnNumber--;
      title = (char) ('A' + columnNumber % 26) + title;
      columnNumber = columnNumber / 26;
    }
    return title;
  }

}