package com.leetcode.easy.design;

import java.util.LinkedList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/07/24,
 * Time:    10:48 pm
 * 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap/description/
 */
public class HashMap {
  class Pair {
    int key;
    int value;

    Pair(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private List<Pair>[] bucket;
  private int size = 10000;

  public HashMap() {
    bucket = new List[size];
    for (int i = 0; i < size; i++) {
      bucket[i] = new LinkedList<>();
    }
  }

  public void put(int key, int value) {
    int bucketNo = key % size;
    List<Pair> chain = bucket[bucketNo];
    for (Pair pair : chain) {
      if (pair.key == key) {
        pair.value = value;
        return;
      }
    }
    chain.add(new Pair(key, value));
  }

  public int get(int key) {
    int bucketNo = key % size;
    List<Pair> chain = bucket[bucketNo];
    for (Pair pair : chain) {
      if (pair.key == key) {
        return pair.value;
      }
    }
    return -1;
  }

  public void remove(int key) {
    int bucketNo = key % size;
    List<Pair> chain = bucket[bucketNo];
    for (Pair pair : chain) {
      if (pair.key == key) {
        chain.remove(pair);
        return;
      }
    }
  }
}