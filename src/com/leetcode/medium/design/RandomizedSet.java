package com.leetcode.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/07/24,
 * Time:    9:46 pm
 */
public class RandomizedSet {
  List<Integer> list;
  Map<Integer, Integer> map;
  Random random;

  public RandomizedSet() {
    list = new ArrayList<>();
    map = new HashMap<>();
    random = new Random();
  }

  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }
    list.add(val);
    map.put(val, list.size() - 1);
    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }
    int index = map.get(val);
    int lastVal = list.get(list.size() - 1);
    list.set(index, lastVal);
    map.put(lastVal, index);
    list.remove(list.size() - 1);
    map.remove(val);
    return true;
  }

  public int getRandom() {
    int randomIndex = random.nextInt(list.size());
    return list.get(randomIndex);
  }
}