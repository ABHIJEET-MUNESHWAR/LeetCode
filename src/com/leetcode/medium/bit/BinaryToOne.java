package com.leetcode.medium.bit;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/05/24,
 * Time:    7:26 am
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/?envType=daily-question&envId=2024-05-29
 */
public class BinaryToOne {
  public static void main(String[] args) {
    BinaryToOne binaryToOne = new BinaryToOne();
    String s = "1101";
    System.out.println(binaryToOne.numStepsSimulation(s));
    System.out.println(binaryToOne.numStepsOptimised(s));
  }

  private int numStepsOptimised(String s) {
    int size = s.length();
    int steps = 0;
    int carry = 0;
    for (int i = size - 1; i > 0; i--) {
      int currentDigit = (s.charAt(i) - '0') + carry;
      if (currentDigit % 2 == 1) { // Odd
        carry = 1;
        steps += 2;
      } else {  // Even
        steps++;
      }
    }
    return steps + carry;
  }

  private int numStepsSimulation(String s) {
    int steps = 0;
    StringBuilder sb = new StringBuilder(s);
    while (sb.length() > 1) {
      int lsb = sb.length() - 1;
      if (sb.charAt(lsb) == '0') {
        sb.deleteCharAt(lsb);
      } else {
        while (lsb >= 0 && sb.charAt(lsb) == '1') {
          sb.setCharAt(lsb--, '0');
        }
        if (lsb > 0) {
          sb.setCharAt(lsb, '1');
        } else {
          sb.insert(0, '1');
        }
      }
      steps++;
    }
    return steps;
  }
}