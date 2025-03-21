package com.leetcode.medium.search;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/06/24,
 * Time:    9:16 am
 * 1552. Magnetic Force Between Two Balls
 * https://leetcode.com/problems/magnetic-force-between-two-balls/description/?envType=daily-question&envId=2024-06-20
 */
public class MagneticForceBetweenTwoBalls {
  public static void main(String[] args) {
    MagneticForceBetweenTwoBalls magneticForceBetweenTwoBalls = new MagneticForceBetweenTwoBalls();
    int[] position = {1, 2, 3, 4, 7};
    int m = 3;
    System.out.println(magneticForceBetweenTwoBalls.maxDistance(position, m));
  }

  private int maxDistance(int[] position, int m) {
    int size = position.length;
    Arrays.sort(position);
    int minForce = 1;
    int maxForce = position[size - 1] - position[0];
    int result = 0;
    while (minForce <= maxForce) {
      int midForce = minForce + (maxForce - minForce) / 2;
      if (possibleToPlace(position, m, midForce)) {
        result = midForce;
        minForce = midForce + 1;
      } else {
        maxForce = midForce - 1;
      }
    }
    return result;
  }

  private boolean possibleToPlace(int[] positions, int m, int force) {
    int ballsCount = 1;
    int previousPosition = positions[0];
    for (int i = 1; i < positions.length; i++) {
      int currentPosition = positions[i];
      if (currentPosition - previousPosition >= force) {
        previousPosition = currentPosition;
        ballsCount++;
      }
      if (ballsCount == m) {
        break;
      }
    }
    return ballsCount == m;
  }
}