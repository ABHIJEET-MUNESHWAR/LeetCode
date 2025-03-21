package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/10/23,
 * Time:    6:24pm
 */
public class CountOperations {
  public static void main(String[] args) {
    CountOperations countOperations = new CountOperations();
    int num1 = 10, num2 = 10;
    System.out.println(countOperations.countOperations(num1, num2));
  }

  private int countOperations(int num1, int num2) {
    int count = 0;
    while (num1 != 0 && num2 != 0) {
      if (num1 > num2) {
        num1 -= num2;
      } else {
        num2 -= num1;
      }
      count++;
    }
    return count;
  }
}