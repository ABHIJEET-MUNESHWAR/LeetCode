package com.leetcode.easy.bit;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/03/24,
 * Time:    2:52 pm
 * https://leetcode.com/problems/number-of-even-and-odd-bits/
 */
public class EvenOddBit {
  public static void main(String[] args) {
    EvenOddBit evenOddBit = new EvenOddBit();
    ArrayUtils.printArray(evenOddBit.evenOddBit(17));
  }

  private int[] evenOddBit(int n) {
    int even = 0, odd = 0;
    boolean flip = true;
    while (n > 0) {
      if (flip) {
        if ((n & 1) == 1) {
          even++;
        }
      } else {
        if ((n & 1) == 1) {
          odd++;
        }
      }
      flip = !flip;
      n = n / 2;
    }
    int[] answer = {even, odd};
    return answer;
  }
}