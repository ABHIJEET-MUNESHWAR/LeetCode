package com.leetcode.medium.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/06/24,
 * Time:    10:27 am
 * 1052. Grumpy Bookstore Owner
 * https://leetcode.com/problems/grumpy-bookstore-owner/description/?envType=daily-question&envId=2024-06-21
 */
public class GrumpyBookstoreOwner {
  public static void main(String[] args) {
    GrumpyBookstoreOwner grumpyBookstoreOwner = new GrumpyBookstoreOwner();
    int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
    int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
    int minutes = 3;
    System.out.println(grumpyBookstoreOwner.maxSatisfied(customers, grumpy, minutes));
  }

  private int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int size = customers.length;
    int maxUnsatisfiedCustomers = 0;
    int currentUnsatisfiedCustomers = 0;
    for (int i = 0; i < minutes; i++) {
      currentUnsatisfiedCustomers += customers[i] * grumpy[i];
    }
    maxUnsatisfiedCustomers = currentUnsatisfiedCustomers;
    int left = 0;
    int right = minutes;
    while (right < size) {
      currentUnsatisfiedCustomers += customers[right] * grumpy[right];
      currentUnsatisfiedCustomers -= customers[left] * grumpy[left];
      maxUnsatisfiedCustomers = Math.max(currentUnsatisfiedCustomers, maxUnsatisfiedCustomers);
      left++;
      right++;
    }
    int totalSatisfied = maxUnsatisfiedCustomers;
    for (int i = 0; i < size; i++) {
      if (grumpy[i] == 0) {
        totalSatisfied += customers[i];
      }
    }
    return totalSatisfied;
  }
}