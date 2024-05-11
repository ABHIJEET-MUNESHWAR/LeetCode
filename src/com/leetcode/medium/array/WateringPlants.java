package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    2:46 pm
 * 2079. Watering Plants
 * https://leetcode.com/problems/watering-plants/description/
 */
public class WateringPlants {
  public static void main(String[] args) {
    WateringPlants wateringPlants = new WateringPlants();
    int[] plants = {1, 1, 1, 4, 2, 3};
    int capacity = 4;
    System.out.println(wateringPlants.wateringPlants(plants, capacity));
  }

  private int wateringPlants(int[] plants, int capacity) {
    int totalSteps = 0;
    int size = plants.length;
    int currentCapacity = capacity;
    for (int i = 0; i < size; i++) {
      if (currentCapacity >= plants[i]) {
        currentCapacity -= plants[i];
        totalSteps++;
      } else {
        currentCapacity = capacity;
        totalSteps += (i * 2) + 1;
        currentCapacity -= plants[i];
      }
    }
    return totalSteps;
  }
}