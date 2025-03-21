package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/05/24,
 * Time:    10:06 am
 * 2125. Number of Laser Beams in a Bank
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/
 */
public class NumberOfLaserBeams {
  public static void main(String[] args) {
    NumberOfLaserBeams numberOfLaserBeams = new NumberOfLaserBeams();
    String[] bank = {"011001", "000000", "010100", "001000"};
    System.out.println(numberOfLaserBeams.numberOfLaserBeams(bank));
  }

  private int numberOfLaserBeams(String[] banks) {
    int totalBeams = 0;
    int totalPreviousDevices = 0;
    for (String bank : banks) {
      int totalDevices = 0;
      for (char cell : bank.toCharArray()) {
        if (cell == '1') {
          totalDevices++;
        }
      }
      if (totalDevices > 0) {
        totalBeams += totalPreviousDevices * totalDevices;
        totalPreviousDevices = totalDevices;
      }
    }
    return totalBeams;
  }
}