package com.leetcode.medium.backtracking;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/06/24,
 * Time:    12:14 am
 * 2305. Fair Distribution of Cookies
 * https://leetcode.com/problems/fair-distribution-of-cookies/description/
 */
public class DistributeCookies {
  public static void main(String[] args) {
    DistributeCookies distributeCookies = new DistributeCookies();
    int[] cookies = {8, 15, 10, 20, 8};
    int k = 2;
    System.out.println(distributeCookies.distributeCookies(cookies, k));
  }

  int result = Integer.MAX_VALUE;

  private int distributeCookies(int[] cookies, int k) {
    int[] children = new int[k];
    solve(cookies, children, k, 0);
    return result;
  }

  private void solve(int[] cookies, int[] children, int k, int start) {
    if (start >= cookies.length) {
      int unfairness = Integer.MIN_VALUE;
      for (int i = 0; i < k; i++) {
        unfairness = Math.max(unfairness, children[i]);
      }
      result = Math.min(unfairness, result);
      return;
    }
    int cookie = cookies[start];
    for (int i = 0; i < k; i++) {
      children[i] += cookie;
      solve(cookies, children, k, start + 1);
      children[i] -= cookie;
    }
  }
}