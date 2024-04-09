package com.leetcode.easy.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/04/24,
 * Time:    7:53 am
 * https://leetcode.com/problems/time-needed-to-buy-tickets/?envType=daily-question&envId=2024-04-09
 */
public class TimeRequiredToBuy {
  public static void main(String[] args) {
    TimeRequiredToBuy timeRequiredToBuy = new TimeRequiredToBuy();
    int[] tickets = {5, 1, 1, 1};
    int k = 0;
    System.out.println(timeRequiredToBuy.timeRequiredToBuy(tickets, k));
  }

  private int timeRequiredToBuy(int[] tickets, int k) {
    int size = tickets.length;
    int time = 0;
    for (int i = 0; i < size; i++) {
      if (i <= k) {
        time += Math.min(tickets[k], tickets[i]);
      } else {
        time += Math.min(tickets[k] - 1, tickets[i]);
      }
    }
    return time;
  }
}