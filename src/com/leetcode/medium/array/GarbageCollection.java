package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/05/24,
 * Time:    9:53 pm
 * 2391. Minimum Amount of Time to Collect Garbage
 * https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/
 */
public class GarbageCollection {
  public static void main(String[] args) {
    GarbageCollection garbageCollection = new GarbageCollection();
    String[] garbage = {"G", "P", "GP", "GG"};
    int[] travel = {2, 4, 3};
    /*String[] garbage = {"MMM", "PGM", "GP"};
    int[] travel = {3, 10};*/
    System.out.println(garbageCollection.garbageCollection(garbage, travel));
  }

  private int garbageCollection(String[] garbage, int[] travel) {
    int time = 0;
    int n = garbage.length;
    int metalLastIndex = 0;
    int paperLastIndex = 0;
    int glassLastIndex = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < garbage[i].length(); j++) {
        if (garbage[i].charAt(j) == 'M') {
          metalLastIndex = i;
        } else if (garbage[i].charAt(j) == 'P') {
          paperLastIndex = i;
        } else {
          glassLastIndex = i;
        }
        time++;
      }
    }
    for (int i = 1; i < travel.length; i++) {
      travel[i] += travel[i - 1];
    }
    time += metalLastIndex > 0 ? travel[metalLastIndex - 1] : 0;
    time += paperLastIndex > 0 ? travel[paperLastIndex - 1] : 0;
    time += glassLastIndex > 0 ? travel[glassLastIndex - 1] : 0;
    return time;
  }
}