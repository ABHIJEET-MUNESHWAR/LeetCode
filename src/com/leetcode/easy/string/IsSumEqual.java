package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    11:36am
 */
public class IsSumEqual {
  public static void main(String[] args) {
    IsSumEqual isSumEqual = new IsSumEqual();
    String firstWord = "acb", secondWord = "cba", targetWord = "cdb";
    System.out.println(isSumEqual.isSumEqual(firstWord, secondWord, targetWord));
  }

  private boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    return ((getIntVal(firstWord) + getIntVal(secondWord)) == getIntVal(targetWord));
  }

  private int getIntVal(String numString) {
    String numStr = "";
    for (char ch : numString.toCharArray()) {
      numStr += ch - 'a';
    }
    return Integer.parseInt(numStr);
  }
}