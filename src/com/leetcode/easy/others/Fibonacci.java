package com.leetcode.easy.others;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/08/22, Time:    5:53 PM 0, 1, 1, 2,
 * 3, 5, 8, 13, 21
 */
public class Fibonacci {

  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci();
    System.out.println("Fibonacci number: " + fibonacci.fibonacci(5));
    System.out.println("Recursive Fibonacci number: " + fibonacci.recursiveFibonacci(5));
  }

  private Integer recursiveFibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

  }

  private Integer fibonacci(int n) {
    int a = 0, b = 1, c = 0;
    for (int i = 0; i < n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }
}