package com.leetcode.easy.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/10/23,
 * Time:    9:55am
 */
public class MergeSimilarItems {
  public static void main(String[] args) {
    MergeSimilarItems mergeSimilarItems = new MergeSimilarItems();
    int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
    int[][] items2 = {{3, 1}, {1, 5}};
    List<List<Integer>> lists = mergeSimilarItems.mergeSimilarItems(items1, items2);
  }

  private List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
    List<List<Integer>> listList = new ArrayList<>();
    TreeMap<Integer, Integer> treeMap1 = new TreeMap<>();
    TreeMap<Integer, Integer> treeMap2 = new TreeMap<>();
    TreeMap<Integer, Integer> treeMap3 = new TreeMap<>();
    int row1 = items1.length;
    int row2 = items2.length;
    for (int i = 0; i < row1; i++) {
      treeMap1.put(items1[i][0], items1[i][1]);
    }
    for (int i = 0; i < row2; i++) {
      treeMap2.put(items2[i][0], items2[i][1]);
    }
    for (Map.Entry<Integer, Integer> entry : treeMap1.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      treeMap3.put(key, treeMap2.getOrDefault(key, 0) + value);
      treeMap1.put(key, 0);
    }
    for (Map.Entry<Integer, Integer> entry : treeMap2.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      if (!treeMap1.containsKey(key)) {
        treeMap3.put(key, treeMap1.getOrDefault(key, 0) + value);
        treeMap2.put(key, 0);
      }
    }
    for (Map.Entry<Integer, Integer> entry : treeMap3.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      List<Integer> integers = new ArrayList<>();
      integers.add(key);
      integers.add(value);
      listList.add(integers);
    }
    return listList;
  }
}