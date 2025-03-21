package com.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/03/24,
 * Time:    1:48 pm
 * https://leetcode.com/problems/bag-of-tokens/?envType=daily-question&envId=2024-03-04
 */
public class BagOfTokensScore {
  public static void main(String[] args) {
    BagOfTokensScore bagOfTokensScore = new BagOfTokensScore();
    /*int[] tokens = {100, 200, 300, 400};
    int power = 200;*/
    int[] tokens = {200, 100};
    int power = 150;
    System.out.println(bagOfTokensScore.bagOfTokensScore(tokens, power));
  }

  private int bagOfTokensScore(int[] tokens, int power) {
    int score = 0;
    int maxScore = 0;
    int size = tokens.length;
    int i = 0, j = size - 1;
    Arrays.sort(tokens);
    while (i <= j) {
      if (power >= tokens[i]) {
        power -= tokens[i++];
        score++;
        maxScore = Math.max(score, maxScore);
      } else if (power < tokens[i] && score > 0) {
        power += tokens[j--];
        score--;
      } else {
        return maxScore;
      }
    }
    return maxScore;
  }
}