package com.leetcode.medium.backtracking;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    31/05/24,
 * Time:    11:47 pm
 */
public class Combinations {
  public static void main(String[] args) {
    Combinations combinations = new Combinations();
    int n = 4, k = 2;
    ListUtils.printLists(combinations.combine(n, k));
  }

  List<List<Integer>> result = new ArrayList<>();

  private List<List<Integer>> combine(int n, int k) {
    List<Integer> temp = new ArrayList<>();
    solve(n, k, 1, temp);
    return result;
  }

  private void solve(int n, int k, int start, List<Integer> temp) {
    if (k == 0) {
      result.add(new ArrayList<>(temp));
      return;
    }
    if (start > n) {
      return;
    }
    temp.add(start);
    solve(n, k - 1, start + 1, temp);
    temp.remove(temp.size() - 1);
    solve(n, k, start + 1, temp);
  }
}