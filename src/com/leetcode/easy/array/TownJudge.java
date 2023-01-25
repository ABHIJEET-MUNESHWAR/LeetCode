package com.leetcode.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
    int[][] trust = {{1, 2}, {2, 3}};
    int n = 3;
    System.out.println(townJudge.findJudge(n, trust));
  }

  private int findJudge(int n, int[][] trust) {
    int judgeLocation = -1;
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < trust.length; i++) {
      map.put(trust[i][0], trust[i][1]);
    }
    for (Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      while (map.containsKey(value)) {
        value = map.get(value);
        if (!visited.isEmpty() && visited.contains(value)) {
          return -1;
        } else {
          visited.add(value);
        }
      }
      judgeLocation = value;
    }
    return judgeLocation;
  }
}