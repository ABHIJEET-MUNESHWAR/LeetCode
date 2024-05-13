package com.leetcode.medium.math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/05/24,
 * Time:    8:34 am
 * 1823. Find the Winner of the Circular Game
 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/
 */
public class FindTheWinner {
  public static void main(String[] args) {
    FindTheWinner findTheWinner = new FindTheWinner();
    int n = 5, k = 2;
    System.out.println(findTheWinner.findTheWinner(n, k));
    System.out.println(findTheWinner.findTheWinnerUsingRecursion(n, k));
    System.out.println(findTheWinner.findTheWinnerUsingFormula(n, k));
  }

  private int findTheWinnerUsingFormula(int n, int k) {
    if (n == 1) {
      return 0;
    }
    int x = findTheWinnerUsingRecursion(n - 1, k);
    int y = (x + k) % n;
    return y;
  }

  private int findTheWinnerUsingRecursion(int n, int k) {
    return solve(n, k) + 1;
  }

  private int solve(int n, int k) {
    if (n == 1) {
      return 0;
    }
    return (k + solve(n - 1, k)) % n;
  }

  private int findTheWinner(int n, int k) {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }
    while (queue.size() != 1) {
      int count = k;
      while (count-- > 1) {
        queue.add(queue.poll());
      }
      queue.poll();
    }
    return queue.poll();
  }
}