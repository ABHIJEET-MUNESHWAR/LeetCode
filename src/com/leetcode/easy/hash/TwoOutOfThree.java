package com.leetcode.easy.hash;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    10:03am
 */
public class TwoOutOfThree {
  public static void main(String[] args) {
    TwoOutOfThree twoOutOfThree = new TwoOutOfThree();
    int[] num1 = {1, 1, 3, 2};
    int[] num2 = {3, 2};
    int[] num3 = {3};
    ArrayUtils.printIntArray(twoOutOfThree.twoOutOfThree(num1, num2, num3));
  }

  private List<Integer> twoOutOfThree(int[] num1, int[] num2, int[] num3) {
    Set<Integer> answer = new HashSet<>();
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    Set<Integer> set3 = new HashSet<>();
    for (int num : num1) {
      set1.add(num);
    }
    for (int num : num2) {
      set2.add(num);
    }
    for (int num : num3) {
      set3.add(num);
    }
    for (int num : set1) {
      if (set2.contains(num) || set3.contains(num)) {
        answer.add(num);
      }
    }
    for (int num : set2) {
      if (set1.contains(num) || set3.contains(num)) {
        answer.add(num);
      }
    }
    for (int num : set3) {
      if (set2.contains(num) || set1.contains(num)) {
        answer.add(num);
      }
    }
    List<Integer> answerList = new ArrayList<>();
    answerList.addAll(answer);
    return answerList;
  }
}