package com.leetcode.medium.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/04/24,
 * Time:    9:03 am
 * 752. Open the Lock
 * https://leetcode.com/problems/open-the-lock/description/?envType=daily-question&envId=2024-04-22
 */
public class OpenTheLock {
  private Set<String> visited = new HashSet<>();

  public static void main(String[] args) {
    OpenTheLock openTheLock = new OpenTheLock();
    String[] deadEnds = {"0201", "0101", "0102", "1212", "2002"};
    String target = "0202";
    System.out.println(openTheLock.openLock(deadEnds, target));
  }

  private int openLock(String[] deadEnds, String target) {
    if (target == null || deadEnds.length == 0) {
      return -1;
    }
    int level = 0;
    for (String deadEnd : deadEnds) {
      visited.add(deadEnd);
    }
    Queue<String> queue = new LinkedList<>();
    queue.add("0000");
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        String currentLock = queue.poll();
        if (visited.contains(currentLock)) {
          continue;
        }
        if (currentLock.equals(target)) {
          return level;
        }
        for (String nextLock : getNextLocks(currentLock)) {
          if (!visited.contains(nextLock)) {
            queue.add(nextLock);
          }
        }
        visited.add(currentLock);
      }
      level++;
    }
    return -1;
  }

  private Set<String> getNextLocks(String currentLock) {
    Set<String> newLocks = new HashSet<>();
    char[] lockChars = currentLock.toCharArray();
    for (int i = 0; i < lockChars.length; i++) {
      char lock = lockChars[i];
      lockChars[i] = lock == '9' ? '0' : (char) (lock + 1);
      newLocks.add(new String(lockChars));
      lockChars[i] = lock == '0' ? '9' : (char) (lock - 1);
      newLocks.add(new String(lockChars));
      lockChars[i] = lock;
    }
    return newLocks;
  }
}