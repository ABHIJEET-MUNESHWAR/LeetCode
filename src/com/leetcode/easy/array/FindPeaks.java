package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    31/01/24,
 * Time:    9:39 am
 * <a href="https://leetcode.com/problems/find-the-peaks/">Find the peaks</a>
 */
public class FindPeaks {
  public static void main(String[] args) {
    FindPeaks findPeaks = new FindPeaks();
    int[] mountain = {1, 4, 3, 8, 5};
    ArrayUtils.printIntArray(findPeaks.findPeaks(mountain));
  }

  private List<Integer> findPeaks(int[] mountain) {
    List<Integer> peaks = new ArrayList<>();
    int size = mountain.length;
    for (int i = 1; i < size - 1; i++) {
      if (isPeak(mountain[i - 1], mountain[i], mountain[i + 1])) {
        peaks.add(i);
      }
    }
    return peaks;
  }

  private boolean isPeak(int a, int b, int c) {
    return (a < b) && (b > c);
  }
}