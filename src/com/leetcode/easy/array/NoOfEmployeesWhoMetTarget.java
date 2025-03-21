package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/08/23,
 * Time:    2:46 pm
 * https://leetcode.com/problems/number-of-employees-who-met-the-target/
 */
public class NoOfEmployeesWhoMetTarget {
  public static void main(String[] args) {
    NoOfEmployeesWhoMetTarget noOfEmployeesWhoMetTarget = new NoOfEmployeesWhoMetTarget();
    int[] hours = {0, 1, 2, 3, 4};
    int target = 2;
    System.out.println(noOfEmployeesWhoMetTarget.noOfEmployeesWhoMetTarget(hours, target));
  }

  private int noOfEmployeesWhoMetTarget(int[] hours, int target) {
    int count = 0;
    int size = hours.length;
    for (int i = 0; i < size; i++) {
      if (hours[i] >= target) {
        count++;
      }
    }
    return count;
  }
}