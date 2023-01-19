package com.leetcode.easy.string;

import java.util.HashSet;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    19/01/23, Time:    2:45 pm
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class NoOfJewelsInStones {

  public static void main(String[] args) {
    NoOfJewelsInStones noOfJewelsInStones = new NoOfJewelsInStones();
    String jewels = "aA";
    String stones = "aAAbbbb";
    System.out.println(noOfJewelsInStones.numJewelsInStones(jewels, stones));
  }

  private int numJewelsInStones(String jewels, String stones) {
    HashSet<Character> jewelsStonesSet = new HashSet<>();
    for (char jewel : jewels.toCharArray()) {
      jewelsStonesSet.add(jewel);
    }
    int count = 0;
    for (char jewel : stones.toCharArray()) {
      if (jewelsStonesSet.contains(jewel)) {
        count++;
      }
    }
    return count;
  }
}