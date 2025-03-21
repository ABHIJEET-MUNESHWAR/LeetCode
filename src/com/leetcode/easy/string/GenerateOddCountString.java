package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/09/23,
 * Time:    4:43 pm
 * https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/description/
 */
public class GenerateOddCountString {
  public static void main(String[] args) {
    GenerateOddCountString generateOddCountString = new GenerateOddCountString();
    System.out.println(generateOddCountString.generateOddCountString(7));
  }

  private String generateOddCountString(int n) {
    String answer = "";
    if (n % 2 == 0) {
      for (int i = 0; i < n - 1; i++) {
        answer += "a";
      }
      answer += "b";
    } else {
      for (int i = 0; i < n; i++) {
        answer += "a";
      }
    }
    return answer;
  }
}