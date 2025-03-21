package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/09/23,
 * Time:    9:18 am
 * https://leetcode.com/problems/remove-trailing-zeros-from-a-string/
 */
public class RemoveTrailingZeros {
  public static void main(String[] args) {
    RemoveTrailingZeros removeTrailingZeros = new RemoveTrailingZeros();
    System.out.println(removeTrailingZeros.removeTrailingZeros("51230100"));
    System.out.println(removeTrailingZeros.removeTrailingZeros2("51230100"));
  }

  private String removeTrailingZeros2(String num) {
    return num.replaceAll("0+$", "");
  }

  private String removeTrailingZeros(String num) {
    String answer = "";
    char[] chars = num.toCharArray();
    int size = chars.length;
    int i = size - 1;
    for (; i >= 0; i--) {
      if (chars[i] != '0') {
        break;
      }
    }
    for (int j = 0; j <= i; j++) {
      answer += chars[j];
    }
    return answer;
  }
}