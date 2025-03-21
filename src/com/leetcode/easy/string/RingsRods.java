package com.leetcode.easy.string;

import java.util.HashSet;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/06/23,
 * Time:    8:54 am
 * https://leetcode.com/problems/rings-and-rods/
 */
public class RingsRods {
  public static void main(String[] args) {
    RingsRods ringsRods = new RingsRods();
    String rings = "B0R0G0R9R0B0G0";
    System.out.println(ringsRods.countPoints(rings));
  }

  private int countPoints(String rings) {
    int count = 0;
    HashSet<Integer> red = new HashSet<>();
    HashSet<Integer> green = new HashSet<>();
    HashSet<Integer> blue = new HashSet<>();
    int size = rings.length();
    for (int i = 0; i < size; i++) {
      char color = rings.charAt(i);
      switch (color) {
        case 'R':
          red.add(rings.charAt(i + 1) - '0');
          break;
        case 'G':
          green.add(rings.charAt(i + 1) - '0');
          break;
        case 'B':
          blue.add(rings.charAt(i + 1) - '0');
          break;
      }
    }
    for (int i = 0; i < size; i++) {
      if (red.contains(i) && blue.contains(i) && green.contains(i)) {
        count++;
      }
    }
    return count;
  }
}