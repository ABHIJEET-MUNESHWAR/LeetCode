package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    8:24pm
 * https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/description/
 */
public class MinTimeToType {
  public static void main(String[] args) {
    MinTimeToType minTimeToType = new MinTimeToType();
    String word = "bza";
    System.out.println(minTimeToType.minTimeToType(word));
  }

  private int minTimeToType(String word) {
    int time = word.length();
    char previous = 'a';
    for (char current : word.toCharArray()) {
      int diff = Math.abs(current - previous);
      time += Math.min(diff, 26 - diff);
      previous = current;
    }
    return time;
  }
}