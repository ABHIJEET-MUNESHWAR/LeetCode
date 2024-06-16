package com.leetcode.medium.graph;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/06/24,
 * Time:    12:59 pm
 * 399. Evaluate Division
 * https://leetcode.com/problems/evaluate-division/description/
 */
public class EvaluateDivision {
  public static void main(String[] args) {
    EvaluateDivision evaluateDivision = new EvaluateDivision();
    List<List<String>> equations = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    list1.add("a");
    list1.add("b");
    equations.add(list1);
    List<String> list2 = new ArrayList<>();
    list2.add("b");
    list2.add("c");
    equations.add(list2);
    double[] values = {2.0, 3.0};
    List<List<String>> queries = new ArrayList<>();
    List<String> queries1 = new ArrayList<>();
    queries1.add("a");
    queries1.add("c");
    queries.add(queries1);
    List<String> queries2 = new ArrayList<>();
    queries2.add("b");
    queries2.add("a");
    queries.add(queries2);
    List<String> queries3 = new ArrayList<>();
    queries3.add("b");
    queries3.add("a");
    queries.add(queries3);
    List<String> queries4 = new ArrayList<>();
    queries4.add("b");
    queries4.add("a");
    queries.add(queries4);
    List<String> queries5 = new ArrayList<>();
    queries5.add("b");
    queries5.add("a");
    queries.add(queries5);
    ArrayUtils.printDoubleArray(evaluateDivision.evaluateDivision(equations, values, queries));
  }

  class Pair {
    String first;
    double second;

    Pair(String _first, double _second) {
      this.first = _first;
      this.second = _second;
    }
  }

  private double ans = -1.0;

  private void DFS(String src, String des, Set<String> visited, Map<String, List<Pair>> adj, double product) {

    if (visited.contains(src)) {
      return;
    }

    visited.add(src);

    if (src.equals(des)) {
      ans = product;
      return;
    }

    for (Pair pair : adj.get(src)) {
      String v = pair.first;
      double val = pair.second;

      DFS(v, des, visited, adj, product * val);
    }
  }

  public double[] evaluateDivision(List<List<String>> equations, double[] values, List<List<String>> queries) {
    int n = equations.size();
    Map<String, List<Pair>> adj = new HashMap<>();

    //Make the graph
    for (int i = 0; i < n; i++) {
      String u = equations.get(i).get(0);
      String v = equations.get(i).get(1);
      double value = values[i];

      adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, value));
      adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 1.0 / value));
    }

    int N = queries.size();
    double[] result = new double[N];

    int pos = 0;

    for (int i = 0; i < N; i++) {
      String src = queries.get(i).get(0);
      String des = queries.get(i).get(1);

      double product = 1.0;

      if (adj.containsKey(src)) {
        if (src.equals(des)) {
          ans = 1.0;
        } else {
          Set<String> visited = new HashSet<>();
          DFS(src, des, visited, adj, product);
        }
      }
      result[i] = ans;
      ans = -1.0;
    }
    return result;

  }
}