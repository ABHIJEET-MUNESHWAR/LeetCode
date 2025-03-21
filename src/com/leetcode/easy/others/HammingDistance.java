package com.leetcode.easy.others;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    5:20 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/762/
 */
public class HammingDistance {

  public static void main(String[] args) {
    HammingDistance hammingDistance = new HammingDistance();
    System.out.println(hammingDistance.hammingDistance(1, 4));
  }

  private int hammingDistance(int x, int y) {
    int dist = 0;
    int z = x ^ y;
    while (z > 0) {
      if ((z & 1) == 1) {
        dist++;
      }
      z = z >>> 1;
    }
    return dist;
  }
}