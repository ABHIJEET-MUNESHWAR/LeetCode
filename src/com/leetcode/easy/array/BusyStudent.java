package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    5:01 pm
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class BusyStudent {
  public static void main(String[] args) {
    BusyStudent busyStudent = new BusyStudent();
    int[] startTime = {1, 2, 3};
    int[] endTime = {3, 2, 7};
    int queryTime = 4;
    System.out.println(busyStudent.busyStudent(startTime, endTime, queryTime));
  }

  private int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    int size = startTime.length;
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
        count++;
      }
    }
    return count;
  }
}