package com.leetcode.easy.simulation;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/07/24,
 * Time:    8:22 am
 * 2582. Pass the Pillow
 * https://leetcode.com/problems/pass-the-pillow/description/?envType=daily-question&envId=2024-07-06
 */
public class PassThePillow {
  public static void main(String[] args) {
    PassThePillow passThePillow = new PassThePillow();
    //int n = 4, time = 5;
    int n = 2, time = 341;
    System.out.println(passThePillow.passThePillow(n, time));
  }

  private int passThePillow(int n, int time) {
    if (n > time) {
      return time + 1;
    } else {
      int division = time / (n - 1);
      int remainder = time % (n - 1);
      if (division % 2 == 0) {
        return (remainder + 1);
      } else {
        return n - remainder;
      }
    }
  }
}