package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    1:20 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/
 */
public class CountPrimes {

  public static void main(String[] args) {
    CountPrimes countPrimes = new CountPrimes();
    System.out.println(countPrimes.countPrimes(10));
  }

  private int countPrimes(int n) {
    boolean[] isNotPrime = new boolean[n];
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (!isNotPrime[i]) {
        count++;
        for (int j = i; j < n; j += i) {
          isNotPrime[j] = true;
        }
      }
    }
    return count;
  }
}