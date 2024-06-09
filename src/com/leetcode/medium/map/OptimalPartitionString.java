package com.leetcode.medium.map;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/06/24,
 * Time:    11:50 pm
 * 2405. Optimal Partition of String
 * https://leetcode.com/problems/optimal-partition-of-string/description/
 */
public class OptimalPartitionString {
  public static void main(String[] args) {
    OptimalPartitionString optimalPartitionString = new OptimalPartitionString();
    String s = "abacaba";
    System.out.println(optimalPartitionString.partitionString(s));
  }

  private int partitionString(String s) {
    int partitionCount = 0;
    Set<Character> set = new HashSet<>();
    for (char c : s.toCharArray()) {
      if (set.contains(c)) {
        partitionCount++;
        set.clear();
        set.add(c);
      } else {
        set.add(c);
      }
    }
    return ++partitionCount;
  }
}