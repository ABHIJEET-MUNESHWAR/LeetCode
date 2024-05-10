package com.leetcode.medium.map;

import com.leetcode.utils.ArrayUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/05/24,
 * Time:    2:42 pm
 * 1817. Finding the Users Active Minutes
 * https://leetcode.com/problems/finding-the-users-active-minutes/description/
 */
public class FindingUsersActiveMinutes {
  public static void main(String[] args) {
    FindingUsersActiveMinutes findingUsersActiveMinutes = new FindingUsersActiveMinutes();
    int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
    int k = 5;
    ArrayUtils.printArray(findingUsersActiveMinutes.findingUsersActiveMinutes(logs, k));
  }

  private int[] findingUsersActiveMinutes(int[][] logs, int k) {
    int[] result = new int[k];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < logs.length; i++) {
      int userId = logs[i][0];
      int minute = logs[i][1];
      Set<Integer> set = new HashSet<>();
      if (map.containsKey(userId)) {
        set = map.get(userId);
      }
      set.add(minute);
      map.put(userId, set);
    }
    for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
      result[entry.getValue().size() - 1]++;
    }
    return result;
  }
}