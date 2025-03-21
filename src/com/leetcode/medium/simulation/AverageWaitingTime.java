package com.leetcode.medium.simulation;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/07/24,
 * Time:    8:14 pm
 * 1701. Average Waiting Time
 * https://leetcode.com/problems/average-waiting-time/description/?envType=daily-question&envId=2024-07-09
 */
public class AverageWaitingTime {
  public static void main(String[] args) {
    AverageWaitingTime averageWaitingTime = new AverageWaitingTime();
    //int[][] customers = {{1, 2}, {2, 5}, {4, 3}};
    int[][] customers = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
    System.out.println(averageWaitingTime.averageWaitingTime(customers));
  }

  private double averageWaitingTime(int[][] customers) {
    int n = customers.length;
    double sum = 0;
    double previousDelay = 0;
    for (int[] customer : customers) {
      double customerArrivalTime = customer[0];
      double cookingDuration = customer[1];
      double cookingStartTime = Math.max(previousDelay, customerArrivalTime);
      double cookingEndTime = cookingStartTime + cookingDuration;
      double waitingTime = cookingEndTime - customerArrivalTime;
      previousDelay = cookingEndTime;
      sum += waitingTime;
    }
    return sum / n;
  }
}