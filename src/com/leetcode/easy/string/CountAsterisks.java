package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/06/23,
 * Time:    10:34 am
 * https://leetcode.com/problems/count-asterisks/
 */
public class CountAsterisks {
  public static void main(String[] args) {
    CountAsterisks countAsterisks = new CountAsterisks();
    System.out.println(countAsterisks.countAsterisks("l|*e*et|c**o|*de|"));
  }

  private int countAsterisks(String s) {
    int count = 0;
    boolean isPipe = true;
    char[] chars = s.toCharArray();
    for (char ch : chars) {
      if (ch == '|') {
        isPipe = !isPipe;
      }
      if (isPipe && ch == '*') {
        count++;
      }
    }
    return count;
  }
}