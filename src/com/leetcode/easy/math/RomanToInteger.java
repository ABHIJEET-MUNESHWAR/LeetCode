package com.leetcode.easy.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    3:27 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/878/
 */
public class RomanToInteger {

  public static void main(String[] args) {
    RomanToInteger romanToInteger = new RomanToInteger();
    System.out.println(romanToInteger.romanToInteger("MCMXCIV"));
    System.out.println(romanToInteger.romanToInteger("LVIII"));
    System.out.println(romanToInteger.romanToInteger("III"));
  }

  private int romanToInteger(String romanNo) {
    Map<Character, Integer> romanToIntMap = new HashMap<>();
    romanToIntMap.put('I', 1);
    romanToIntMap.put('V', 5);
    romanToIntMap.put('X', 10);
    romanToIntMap.put('L', 50);
    romanToIntMap.put('C', 100);
    romanToIntMap.put('D', 500);
    romanToIntMap.put('M', 1000);
    int len = romanNo.length() - 1;
    char currentChar = romanNo.charAt(len);
    int intNo = romanToIntMap.get(currentChar);
    char previousChar = currentChar;
    while (--len >= 0) {
      currentChar = romanNo.charAt(len);
      if (romanToIntMap.get(currentChar) < romanToIntMap.get(previousChar)) {
        intNo -= romanToIntMap.get(currentChar);
      } else {
        intNo += romanToIntMap.get(currentChar);
      }
      previousChar = currentChar;
    }
    return intNo;
  }
}