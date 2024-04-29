package com.leetcode.hard.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/04/24,
 * Time:    7:48 am
514. Freedom Trail
https://leetcode.com/problems/freedom-trail/description/?envType=daily-question&envId=2024-04-27
*/
public class FreedomTrail {
  public static void main(String[] args) {
    FreedomTrail freedomTrail = new FreedomTrail();
    String ring = "godding", key = "gd";
    System.out.println(freedomTrail.findRotateSteps(ring, key));
  }

  private int findRotateSteps(String ring, String key) {
    int[][] dp = new int[key.length()][ring.length()];
    for (int i = 0; i < key.length(); i++) {
      Arrays.fill(dp[i], -1);
    }
    ArrayList<Integer> positionsMap[] = new ArrayList[26];
    int ringSize = ring.length();
    for (int i = 0; i < ringSize; i++) {
      char c = ring.charAt(i);
      int index = c - 'a';
      if (positionsMap[index] == null) {
        positionsMap[index] = new ArrayList<>();
      }
      positionsMap[index].add(i);
    }
    return minSteps(ring, key, 0, 0, positionsMap, dp);
  }

  private int minSteps(String ring, String key, int ringIndex, int keyIndex, ArrayList<Integer>[] positionsMap, int[][] dp) {
    // Base case
    if (keyIndex == key.length()) {
      return 0;
    }
    if (dp[keyIndex][ringIndex] != -1) {
      return dp[keyIndex][ringIndex];
    }
    // Generate all possibilities
    // keyIndex
    int charIndex = key.charAt(keyIndex) - 'a';
    List<Integer> positions = positionsMap[charIndex];
    int minAnswer = Integer.MAX_VALUE;
    for (int position : positions) {
      int clockwiseStep = Math.abs(ringIndex - position);
      int antiClockwiseStep = ring.length() - clockwiseStep;
      int minStep = Math.min(clockwiseStep, antiClockwiseStep);
      int currentAnswer = minStep + minSteps(ring, key, position, keyIndex + 1, positionsMap, dp);
      minAnswer = Math.min(minAnswer, currentAnswer);
    }
    return dp[keyIndex][ringIndex] = 1 + minAnswer; // 1 is for button press
  }
}
