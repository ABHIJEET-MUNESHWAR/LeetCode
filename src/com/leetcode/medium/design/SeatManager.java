package com.leetcode.medium.design;

import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/07/24,
 * Time:    12:23 am
 * 1845. Seat Reservation Manager
 * https://leetcode.com/problems/seat-reservation-manager/description/
 */
public class SeatManager {
  private PriorityQueue<Integer> pq;
  private int seatMarker;

  public SeatManager(int n) {
    pq = new PriorityQueue<>();
    seatMarker = 1;
  }

  public int reserve() {
    if (!pq.isEmpty()) {
      int seat = pq.poll();
      return seat;
    }
    int seat = seatMarker;
    seatMarker++;
    return seat;
  }

  public void unreserve(int seatNumber) {
    pq.add(seatNumber);
  }
}