package com.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/09/22, Time:    9:23 AM
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/ n = 4, k = 2 1313
 */
public class NumbersWithSameConsecutiveDiff {

  public static void main(String[] args) {
    NumbersWithSameConsecutiveDiff numbersWithSameConsecutiveDiff = new NumbersWithSameConsecutiveDiff();
    int[] numbers = numbersWithSameConsecutiveDiff.numbersWithSameConsecutiveDiff(3, 7);
    System.out.println(numbers);
  }

  private int[] numbersWithSameConsecutiveDiff(int N, int K) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    for (int i = 2; i <= N; i++) {
      List<Integer> current = new ArrayList<>();
      for (Integer num : numbers) {
        int mod = num % 10;
        if (mod + K < 10) {
          num = num * 10 + mod + K;
          current.add(num);
        }
        if (K > 0 && (mod - K >= 0)) {
          num = num * 10 + mod - K;
          current.add(num);
        }
      }
      numbers = current;
    }
    return numbers.stream().mapToInt(i -> i).toArray();
  }

}