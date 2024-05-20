package com.leetcode.medium.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/05/24,
 * Time:    3:22 pm
 * 853. Car Fleet
 * https://leetcode.com/problems/car-fleet/description/
 */
class CarState {
  int speed;
  int distance;
  double time;

  public CarState(int speed, int distance, double time) {
    this.speed = speed;
    this.distance = distance;
    this.time = time;
  }
}

public class CarFleet {

  public static void main(String[] args) {
    CarFleet carFleet = new CarFleet();
    int target = 12;
    int[] position = {10, 8, 0, 5, 3};
    int[] speed = {2, 4, 1, 1, 3};
    System.out.println(carFleet.carFleet(target, position, speed));
  }

  private int carFleet(int target, int[] position, int[] speed) {
    int N = position.length, res = 0;
    double[][] cars = new double[N][2];
    for (int i = 0; i < N; ++i) {
      cars[i] = new double[] {position[i], (double) (target - position[i]) / speed[i]};
    }
    Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
    double cur = 0;
    for (int i = N - 1; i >= 0; --i) {
      if (cars[i][1] > cur) {
        cur = cars[i][1];
        res++;
      }
    }
    return res;
  }
}