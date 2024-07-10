package com.leetcode.medium.design;

import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/07/24,
 * Time:    9:00 pm
 * 1146. Snapshot Array
 * https://leetcode.com/problems/snapshot-array/description/
 */
class SnapshotArray {

  TreeMap<Integer, Integer>[] map;
  int snapId = 0;

  public SnapshotArray(int length) {
    map = new TreeMap[length];
    for (int i = 0; i < length; i++) {
      map[i] = new TreeMap<>();
      map[i].put(0, 0);
    }
  }

  public void set(int index, int val) {
    map[index].put(snapId, val);
  }

  public int snap() {
    return snapId++;
  }

  public int get(int index, int snapId) {
    return map[index].floorEntry(snapId).getValue();
  }
}