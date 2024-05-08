package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/11/22, Time:    9:18 PM
 * https://leetcode.com/problems/relative-ranks/description/
 */
public class RelativeRanks {

  public static void main(String[] args) {
    RelativeRanks relativeRanks = new RelativeRanks();
    int[] score = new int[]{5, 4, 3, 2, 1};
    //int[] score = new int[]{1};
    String[] ans = relativeRanks.findRelativeRanks(score);
    ArrayUtils.printArray(ans);
  }

  private String[] findRelativeRanks(int[] score) {
    Map<Integer, String> positionMap = new HashMap<>();
    int size = score.length;
    String[] ans = new String[size];
    for (int i = 0; i < size; i++) {
      positionMap.put(score[i], (i + 1) + "");
    }
    int[] inputScore = new int[size];
    for (int i = 0; i < size; i++) {
      inputScore[i] = score[i];
    }
    Arrays.sort(score);
    for (int i = size - 4, j = 0; i >= 0; i--, j++) {
      positionMap.put(score[i], (j + 4) + "");
    }
    int startIndex = size - 3;
    if (size == 1) {
      positionMap.put(score[0], "Gold Medal");
    } else if (size == 2) {
      positionMap.put(score[0], "Silver Medal");
      positionMap.put(score[1], "Gold Medal");
    } else {
      positionMap.put(score[startIndex++], "Bronze Medal");
      positionMap.put(score[startIndex++], "Silver Medal");
      positionMap.put(score[startIndex++], "Gold Medal");
    }
    for (int i = 0; i < size; i++) {
      ans[i] = positionMap.get(inputScore[i]);
    }
    return ans;
  }
}