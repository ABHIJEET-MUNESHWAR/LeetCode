package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    20/06/22, Time:    7:56 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 */
public class PlusOne {

  public static void main(String[] args) {
//    int[] digits = new int[]{1, 2, 3};
//    int[] digits = new int[]{4,3,2,1};
//    int[] digits = new int[]{9};
//    int[] digits = new int[]{8, 9, 9, 9};
    int[] digits = new int[]{9,9,8,9};
    PlusOne plusOne = new PlusOne();
    //System.out.println("nums3 = " + Arrays.toString(plusOne.plusOne(digits)));
    System.out.println("nums3 = " + Arrays.toString(plusOne.plusOneAnotherSolution(digits)));
  }

  private int[] plusOneAnotherSolution(int[] digits) {
    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    int[] newNumber = new int[n + 1];
    newNumber[0] = 1;

    return newNumber;
  }

  private int[] plusOne(int[] digits) {
    int len = digits.length;
    for (int i = 0, j = len - 1; i <= j; i++, j--) {
      int temp = digits[i];
      digits[i] = digits[j];
      digits[j] = temp;
    }
    ArrayList<Integer> plusOneArrayList = new ArrayList<>();
    int sum = 0;
    int carry = 0;
    for (int i = 0; i < len; i++) {
      int total = digits[i] + carry;
      carry = 0;
      if (i == 0) {
        total++;
      }
      if (total > 9) {
        sum = total % 10;
        carry = total / 10;
      } else {
        sum = total;
      }
      plusOneArrayList.add(sum);
    }
    if (carry != 0) {
      plusOneArrayList.add(carry);
    }
    int plusOneArrayListLen = plusOneArrayList.size();
    int[] plusOneArray = new int[plusOneArrayListLen];
    for (int i = plusOneArrayListLen - 1, j = 0; i >= 0; i--, j++) {
      plusOneArray[i] = plusOneArrayList.get(j);
    }
    return plusOneArray;
  }
}