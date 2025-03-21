package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    14/09/22, Time:    6:50 AM
 * https://leetcode.com/problems/nim-game/
 */
public class NimGame {

  public static void main(String[] args) {
    NimGame nimGame = new NimGame();
    System.out.println(nimGame.canWinNim(4));
  }

  private boolean canWinNim(int n) {
    return n % 4 != 0;
  }
}