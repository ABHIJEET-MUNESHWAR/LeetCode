package com.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/05/24,
 * Time:    9:40 am
 * 881. Boats to Save People
 * https://leetcode.com/problems/boats-to-save-people/description/?envType=daily-question&envId=2024-05-04
 */
public class BoatsToSavePeople {
  public static void main(String[] args) {
    BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
    /*int[] people = {5, 1, 4, 2};
    int limit = 6;*/
    int[] people = {3, 5, 3, 4};
    int limit = 5;
    System.out.println(boatsToSavePeople.numRescueBoats(people, limit));
  }

  private int numRescueBoats(int[] people, int limit) {
    int totalBoats = 0;
    Arrays.sort(people);
    int totalPeople = people.length;
    int left = 0, right = totalPeople - 1;
    while (left <= right) {
      int currentBoatCapacity = people[left] + people[right];
      if (currentBoatCapacity <= limit) {
        left++;
        right--;
      } else {
        right--;
      }
      totalBoats++;
    }
    return totalBoats;
  }
}