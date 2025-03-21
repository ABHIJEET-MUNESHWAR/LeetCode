package com.leetcode.easy.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    12:55 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/743/
 */
public class FizzBuzz {

  public static void main(String[] args) {
    FizzBuzz fizzBuzz = new FizzBuzz();
    List<String> fizzBuzzArray = fizzBuzz.fizzBuzz(5);
    System.out.println(fizzBuzzArray);
  }

  private List<String> fizzBuzz(int n) {
    List<String> fizzBuzzArray = new ArrayList<>();
    int i = 1;
    int j = 0;
    while (i <= n) {
      if (i % 3 == 0 && i % 5 == 0) {
        fizzBuzzArray.add("FizzBuzz");
      } else if (i % 3 == 0) {
        fizzBuzzArray.add("Fizz");
      } else if (i % 5 == 0) {
        fizzBuzzArray.add("Buzz");
      } else {
        fizzBuzzArray.add(String.valueOf(i));
      }
      i++;
      j++;
    }
    return fizzBuzzArray;
  }
}