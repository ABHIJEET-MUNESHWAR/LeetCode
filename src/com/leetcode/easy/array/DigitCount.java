package com.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/09/23,
 * Time:    12:59 pm
 */
public class DigitCount {
  public static void main(String[] args) {
    DigitCount digitCount = new DigitCount();
    System.out.println(digitCount.digitCount("030"));
  }

  private boolean digitCount(String number) {
    char[] chars = number.toCharArray();
    Map<Integer, Integer> map = new HashMap<>();
    for (char ch : chars) {
      int chInt = (int) ch - '0';
      if (map.containsKey(chInt)) {
        map.put(chInt, map.get(chInt) + 1);
      } else {
        map.put(chInt, 1);
      }
    }
    int size = chars.length;
    for (int i = 0; i < size; i++) {
      int occurance = 0;
      if (map.containsKey(i)) {
        occurance = map.get(i);
      }
      if ((chars[i] - '0') != occurance) {
        return false;
      }
    }
    return true;
  }
}