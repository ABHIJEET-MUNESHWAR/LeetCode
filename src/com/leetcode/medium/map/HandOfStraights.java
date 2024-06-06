package com.leetcode.medium.map;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/06/24,
 * Time:    9:41 am
 * 846. Hand of Straights
 * https://leetcode.com/problems/hand-of-straights/description/?envType=daily-question&envId=2024-06-06
 */
public class HandOfStraights {
  public static void main(String[] args) {
    HandOfStraights handOfStraights = new HandOfStraights();
    int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
    int groupSize = 3;
    System.out.println(handOfStraights.isNStraightHand(hand, groupSize));
  }

  private boolean isNStraightHand(int[] hand, int groupSize) {
    int size = hand.length;
    if (size % groupSize != 0) {
      return false;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : hand) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int num : map.keySet()) {
      pq.add(num);
    }
    while (!pq.isEmpty()) {
      int num = pq.peek();
      int j = 0;
      for (int i = j; i < j + groupSize; i++) {
        if (map.containsKey(num + i)) {
          int value = map.get(num + i);
          if (value > 1) {
            map.put(num + i, map.get(num + i) - 1);
          } else if (value == 1) {
            map.remove(num + i);
            pq.poll();
          } else {
            return false;
          }
        } else {
          return false;
        }
      }
      j += groupSize;
    }
    return true;
  }
}