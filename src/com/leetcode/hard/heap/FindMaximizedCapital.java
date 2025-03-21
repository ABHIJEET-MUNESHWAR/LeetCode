package com.leetcode.hard.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/06/24,
 * Time:    9:10 am
 * 502. IPO
 * https://leetcode.com/problems/ipo/description/?envType=daily-question&envId=2024-06-15
 */
public class FindMaximizedCapital {
  public static void main(String[] args) {
    FindMaximizedCapital obj = new FindMaximizedCapital();
    int k = 3, w = 0;
    int[] profits = {1, 2, 3, 1};
    int[] capital = {0, 1, 1, 2};
    System.out.println(obj.findMaximizedCapital(k, w, profits, capital));
  }

  private int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int size = profits.length;
    int[][] projects = new int[size][2];
    for (int i = 0; i < size; i++) {
      projects[i][0] = capital[i];
      projects[i][1] = profits[i];
    }
    Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0])); // Sort based on capital value
    int i = 0;
    PriorityQueue<Integer> maximiseCapital = new PriorityQueue<>(Collections.reverseOrder());
    while (k-- > 0) {
      while (i < size && projects[i][0] <= w) {
        maximiseCapital.add(projects[i][1]);
        i++;
      }
      if (maximiseCapital.isEmpty()) {
        break;
      }
      w += maximiseCapital.poll();
    }
    return w;
  }
}