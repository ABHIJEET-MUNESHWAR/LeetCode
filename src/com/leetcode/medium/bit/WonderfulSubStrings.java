package com.leetcode.medium.bit;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/04/24,
 * Time:    10:58 am
 * 1915. Number of Wonderful Substrings
 * https://www.youtube.com/watch?v=1DdmbJj4xLE&ab_channel=codestorywithMIK
 * https://leetcode.com/problems/number-of-wonderful-substrings/description/?envType=daily-question&envId=2024-04-30
 */
public class WonderfulSubStrings {
  public static void main(String[] args) {
    WonderfulSubStrings wonderfulSubStrings = new WonderfulSubStrings();
    String word = "aba";
    System.out.println(wonderfulSubStrings.wonderfulSubStrings(word));
  }

  private long wonderfulSubStrings(String word) {
    long result = 0;
    int size = word.length();
    int[] countMap = new int[1024];
    int cumulativeXor = 0;
    countMap[0] = 1;
    for (int i = 0; i < size; i++) {
      cumulativeXor = cumulativeXor ^ (1 << ((int) (word.charAt(i) - 'a')));
      result += countMap[cumulativeXor];
      for (int j = 0; j < 10; j++) {
        int checkXor = cumulativeXor ^ (1 << j);
        result += countMap[checkXor];
      }
      countMap[cumulativeXor]++;
    }
    return result;
  }
}