package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/09/22, Time:    6:32 AM
 * https://leetcode.com/problems/teemo-attacking/
 */
public class TeemoAttacking {

  public static void main(String[] args) {
    TeemoAttacking teemoAttacking = new TeemoAttacking();
    int[] timeSeries = new int[]{1, 2, 3, 4, 5};
    int duration = 5;
    System.out.println(teemoAttacking.findPoisonedDuration(timeSeries, duration));
  }

  private int findPoisonedDuration(int[] timeSeries, int duration) {
    int poisonedDuration = 0;
    int begin = timeSeries[0];
    for (int t : timeSeries) {
      poisonedDuration = poisonedDuration + (t > begin + duration ? duration : t - begin);
      begin = t;
    }
    return poisonedDuration + duration;
  }
}