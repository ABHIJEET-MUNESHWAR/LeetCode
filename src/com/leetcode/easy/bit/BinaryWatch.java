package com.leetcode.easy.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    6:06 PM
 * https://leetcode.com/problems/binary-watch/
 */
public class BinaryWatch {

  public static void main(String[] args) {
    BinaryWatch binaryWatch = new BinaryWatch();
    List<String> times = binaryWatch.readBinaryWatch(1);
  }

  private List<String> readBinaryWatch(int turnedOn) {
    List<String> times = new ArrayList<>();
    if (turnedOn < 0 || turnedOn > 10) {
      return times;
    }
    for (int hour = 0; hour < 12; hour++) {
      for (int minute = 0; minute < 60; minute++) {
        if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
          times.add(String.format("%d:%02d", hour, minute));
        }
      }
    }
    return times;
  }
}