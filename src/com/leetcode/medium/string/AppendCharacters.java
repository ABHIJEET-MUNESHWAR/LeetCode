package com.leetcode.medium.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/06/24,
 * Time:    11:55 am
 * 2486. Append Characters to String to Make Subsequence
 * https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/?envType=daily-question&envId=2024-06-03
 */
public class AppendCharacters {
  public static void main(String[] args) {
    AppendCharacters app = new AppendCharacters();
    String s = "coaching", t = "coding";
    //String s = "lbg", t = "g";
    System.out.println(app.appendCharacters(s, t));
  }

  private int appendCharacters(String s, String t) {
    int sourceSize = s.length();
    int targetSize = t.length();
    int answer = 0;
    int i = 0, j = 0;
    while (i < sourceSize && j < targetSize) {
      if (s.charAt(i) == t.charAt(j)) {
        j++;
        i++;
      } else {
        i++;
      }
    }
    answer = targetSize - j;
    return answer;
  }
}