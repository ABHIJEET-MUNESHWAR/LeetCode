package com.leetcode.easy.simulation;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/07/24,
 * Time:    8:58 am
 */
public class WaterBottles {
  public static void main(String[] args) {
    WaterBottles waterBottles = new WaterBottles();
    int numBottles = 9, numExchange = 3;
    //int numBottles = 15, numExchange = 4;
    System.out.println(waterBottles.numWaterBottles(numBottles, numExchange));
  }

  private int numWaterBottles(int numBottles, int numExchange) {
    int totalFullBottles = 0;
    int totalEmptyBottles = numBottles;
    int totalBottlesDrank = numBottles;
    while (totalEmptyBottles >= numExchange) {
      totalFullBottles = totalEmptyBottles / numExchange;
      totalEmptyBottles = totalEmptyBottles % numExchange + totalFullBottles;
      totalBottlesDrank += totalFullBottles;
    }
    return totalBottlesDrank;
  }
}