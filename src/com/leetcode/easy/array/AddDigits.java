package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/09/22, Time:    6:02 PM
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {

  public static void main(String[] args) {
    AddDigits addDigits = new AddDigits();
    System.out.println(addDigits.addDigits(0));
  }

  private int addDigits(int num) {
    if (num < 10) {
      return num;
    }
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num = num / 10;
      if (num == 0) {
        num = sum;
        if (sum < 10) {
          return sum;
        }
        sum = 0;
      }
    }
    return sum;
  }
}