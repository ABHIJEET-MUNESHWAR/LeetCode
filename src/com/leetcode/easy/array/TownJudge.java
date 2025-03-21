package com.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    23/01/23, Time:    8:41 am
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class TownJudge {

  public static void main(String[] args) {
    TownJudge townJudge = new TownJudge();
//    int[][] trust = {{1, 2}};
//    int n = 2;
//    int[][] trust = {{1, 3}, {2, 3}};
//    int n = 3;
//    int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
//    int n = 3;
    int[][] trust = {{1, 3}, {2, 3}};
    int n = 3;
    System.out.println(townJudge.findJudge(n, trust));
    System.out.println(townJudge.findTownJudge(n, trust));
  }

  private int findTownJudge(int n, int[][] trust) {
    int[] count = new int[n + 1];
    for (int[] t : trust) {
      count[t[0]]--;
      count[t[1]]++;
    }
    for (int i = 1; i <= n; i++) {
      if (count[i] == n - 1) {
        return i;
      }
    }
    return -1;
  }

  private int findJudge(int n, int[][] trust) {
    if (trust.length == 0 && n == 1) {
      return 1;
    }
    Map<Integer, Integer> people = new HashMap<>();
    Map<Integer, Integer> possibleJudges = new HashMap<>();
    for (int i = 0; i < trust.length; i++) {
      people.put(trust[i][0], people.getOrDefault(trust[i][0], 0) + 1);
      possibleJudges.put(trust[i][1], possibleJudges.getOrDefault(trust[i][1], 0) + 1);
    }
    for (Entry<Integer, Integer> entry : possibleJudges.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      if (!people.containsKey(key) && value == n - 1) {
        return key;
      }
    }
    return -1;
  }
}