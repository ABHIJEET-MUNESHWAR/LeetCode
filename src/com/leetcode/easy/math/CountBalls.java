package com.leetcode.easy.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    10:54pm
 */
public class CountBalls {
  public static void main(String[] args) {
    CountBalls countBalls = new CountBalls();
    int lowLimit = 19, highLimit = 28;
    System.out.println(countBalls.countBalls(lowLimit, highLimit));
  }

  private int countBalls(int lowLimit, int highLimit) {
    Map<Integer, Integer> boxNumToBallCountMap = new HashMap<>();
    for (int i = lowLimit; i <= highLimit; i++) {
      int boxNumber = getBoxNumber(i);
      boxNumToBallCountMap.put(boxNumber, boxNumToBallCountMap.getOrDefault(boxNumber, 0) + 1);
    }
    int max = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry : boxNumToBallCountMap.entrySet()) {
      int value = entry.getValue();
      if (max < value) {
        max = value;
      }
    }
    return max;
  }

  private int getBoxNumber(int n) {
    int boxNumber = 0;
    while (n > 0) {
      boxNumber += n % 10;
      n /= 10;
    }
    return boxNumber;
  }
}