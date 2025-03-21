package com.leetcode.hard.graph;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/07/24,
 * Time:    6:25 pm
 * 2392. Build a Matrix With Conditions
 * https://leetcode.com/problems/build-a-matrix-with-conditions/description/
 */
public class BuildMatrix {
    public static void main(String[] args) {
        BuildMatrix buildMatrix = new BuildMatrix();
        int k = 3;
        int[][] rowConditions = new int[][] {{1, 2}, {3, 2}};
        int[][] colConditions = new int[][] {{2, 1}, {3, 2}};
        ArrayUtils.printMatrix(buildMatrix.buildMatrixDfs(k, rowConditions, colConditions));
        ArrayUtils.printMatrix(buildMatrix.buildMatrixBfs(k, rowConditions, colConditions));
    }

    private int[][] buildMatrixBfs(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        List<Integer> topologicalRows = topologicalSortBfs(rowConditions, k);
        List<Integer> topologicalCols = topologicalSortBfs(colConditions, k);
        if (topologicalCols.isEmpty() || topologicalRows.isEmpty()) {
            return new int[][] {}; // Found cycle. Answer is not possible.
        }
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            positionMap.put(topologicalCols.get(i), i);
        }
        for (int i = 0; i < k; i++) {
            int element = topologicalRows.get(i);
            if (positionMap.containsKey(element)) {
                matrix[i][positionMap.get(element)] = element;
            }
        }
        return matrix;
    }

    private List<Integer> topologicalSortBfs(int[][] edges, int n) {
        // Build adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegrees = new int[n + 1];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            inDegrees[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);
            for (int v : adjacencyList.get(u)) {
                inDegrees[v]--;
                if (inDegrees[v] == 0) {
                    queue.add(v);
                    count++;
                }
            }
        }
        if (count != n) {
            return new ArrayList<>(); // Cycle detected
        }
        return order;
    }

    private int[][] buildMatrixDfs(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        List<Integer> topologicalRows = topologicalSortDfs(rowConditions, k);
        List<Integer> topologicalCols = topologicalSortDfs(colConditions, k);
        if (topologicalCols.isEmpty() || topologicalRows.isEmpty()) {
            return new int[][] {}; // Found cycle. Answer is not possible.
        }
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            positionMap.put(topologicalCols.get(i), i);
        }
        for (int i = 0; i < k; i++) {
            int element = topologicalRows.get(i);
            if (positionMap.containsKey(element)) {
                matrix[i][positionMap.get(element)] = element;
            }
        }
        return matrix;
    }

    private List<Integer> topologicalSortDfs(int[][] edges, int n) {
        // Build adjacency list
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> order = new ArrayList<>();
        int[] visited = new int[n + 1]; // 0: not visited, 1: DFS is in progress, 2: visited
        boolean[] hasCycle = {false};
        for (int[] edge : edges) {
            adjacencyMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs(i, adjacencyMap, visited, stack, hasCycle);
                if (hasCycle[0]) {
                    return new ArrayList<>(); // no ordering possible
                }
            }
        }
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return order;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adjacencyMap, int[] visited, Stack<Integer> stack, boolean[] hasCycle) {
        visited[node] = 1; // Mark node as visiting
        for (int neighbour : adjacencyMap.getOrDefault(node, new ArrayList<>())) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, adjacencyMap, visited, stack, hasCycle);
            } else if (visited[neighbour] == 1) {
                hasCycle[0] = true; // Cycle detected
                return;
            }
        }
        visited[node] = 2; // Mark node as visited
        stack.push(node); // Add node to the stack
    }
}