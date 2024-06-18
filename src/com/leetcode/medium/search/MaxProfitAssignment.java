package com.leetcode.medium.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    18/06/24,
 * Time:    8:15 am
 * 826. Most Profit Assigning Work
 * https://leetcode.com/problems/most-profit-assigning-work/description/?envType=daily-question&envId=2024-06-18
 */
public class MaxProfitAssignment {
  public static void main(String[] args) {
    MaxProfitAssignment maxProfitAssignment = new MaxProfitAssignment();
    int[] difficulty = {2, 4, 6, 8, 10};
    int[] profit = {10, 20, 30, 40, 50};
    int[] worker = {4, 5, 6, 7};
    System.out.println(maxProfitAssignment.maxProfitAssignmentPriorityQueue(difficulty, profit, worker));
    System.out.println(maxProfitAssignment.maxProfitAssignmentBinarySearch(difficulty, profit, worker));
    System.out.println(maxProfitAssignment.maxProfitAssignmentSort(difficulty, profit, worker));
  }

  private int maxProfitAssignmentSort(int[] difficulty, int[] profit, int[] worker) {
    int workerSize = worker.length;
    int difficultySize = difficulty.length;
    int totalProfit = 0;
    // Create an array of pairs to hold difficulty and profit
    int[][] jobs = new int[difficultySize][2];
    for (int i = 0; i < difficultySize; i++) {
      jobs[i][0] = difficulty[i];
      jobs[i][1] = profit[i];
    }
    // Sort the vector based on difficulty
    Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
    // Sort the worker array
    Arrays.sort(worker);
    int j = 0; // Pointer to vec array
    int maxProfit = 0;
    for (int i = 0; i < workerSize; i++) {
      while (j < difficultySize && worker[i] >= jobs[j][0]) {
        maxProfit = Math.max(maxProfit, jobs[j][1]);
        j++;
      }
      totalProfit += maxProfit;
    }
    return totalProfit;
  }

  private int maxProfitAssignmentBinarySearch(int[] difficulty, int[] profit, int[] worker) {
    int workerSize = worker.length;
    int difficultySize = difficulty.length;
    int totalProfit = 0;
    List<int[]> jobsList = new ArrayList<>();
    for (int i = 0; i < difficultySize; i++) {
      jobsList.add(new int[] {difficulty[i], profit[i]});
    }
    // Sort the vector based on difficulty
    Collections.sort(jobsList, (a, b) -> Integer.compare(a[0], b[0]));
    // Pre-processing to find the maximum profit till index i at constant time
    for (int i = 1; i < difficultySize; i++) {
      jobsList.get(i)[1] = Math.max(jobsList.get(i)[1], jobsList.get(i - 1)[1]);
    }
    for (int i = 0; i < workerSize; i++) {
      int workerDifficulty = worker[i];
      // Apply binary search on vec
      int low = 0;
      int high = difficultySize - 1;
      int maxProfit = 0;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        if (jobsList.get(mid)[0] <= workerDifficulty) {
          maxProfit = Math.max(maxProfit, jobsList.get(mid)[1]);
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      totalProfit += maxProfit;
    }
    return totalProfit;
  }

  private int maxProfitAssignmentPriorityQueue(int[] difficulty, int[] profit, int[] worker) {
    int profitSize = profit.length;
    int workerSize = worker.length;
    // Create a max-heap using a priority queue
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max-heap by profit

    for (int i = 0; i < profitSize; i++) {
      pq.offer(new int[] {profit[i], difficulty[i]});
    }
    int totalProfit = 0;
    Arrays.sort(worker);
    for (int i = 0; i < workerSize / 2; i++) {
      int temp = worker[i];
      worker[i] = worker[workerSize - i - 1];
      worker[workerSize - i - 1] = temp;
    }
    int i = 0;
    while (i < workerSize && !pq.isEmpty()) {
      if (pq.peek()[1] > worker[i]) {
        pq.poll();
      } else {
        totalProfit += pq.peek()[0];
        i++;
      }
    }
    return totalProfit;
  }
}