package com.leetcode.medium.bit;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/04/24,
 * Time:    9:57 am
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
  public static void main(String[] args) {
    PartitioningIntoMinimumNumberOfDeciBinaryNumbers partitioningIntoMinimumNumberOfDeciBinaryNumbers =
        new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
    String n = "27346209830709182346";
    System.out.println(partitioningIntoMinimumNumberOfDeciBinaryNumbers.minPartitions(n));
  }

  private int minPartitions(String n) {
    int ans = 0;
    for (char ch : n.toCharArray()) {
      ans = Math.max(ans, ch - '0');
    }
    return ans;
  }
}