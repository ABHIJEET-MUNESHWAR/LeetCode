package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;
import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/05/24,
 * Time:    11:51 am
 * 1409. Queries on a Permutation With Key
 * https://leetcode.com/problems/queries-on-a-permutation-with-key/description/
 */
public class ProcessQueries {
  public static void main(String[] args) {
    ProcessQueries processQueries = new ProcessQueries();
    int[] queries = {3, 1, 2, 1};
    int m = 5;
    ArrayUtils.printArray(processQueries.processQueries(queries, m));
  }

  private int[] processQueries(int[] queries, int m) {
    int size = queries.length;
    int[] answer = new int[size];
    LinkedList<Integer> permutations = new LinkedList<>();
    for (int i = 1; i <= m; i++) {
      permutations.add(i);
    }
    for (int i = 0; i < size; i++) {
      int index = permutations.indexOf(queries[i]);
      answer[i] = index;
      permutations.addFirst(permutations.remove(index));
    }
    return answer;
  }
}