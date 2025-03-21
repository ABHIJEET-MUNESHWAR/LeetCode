package com.leetcode.hard.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/07/24,
 * Time:    3:55 pm
 * 2045. Second Minimum Time to Reach Destination
 * https://leetcode.com/problems/second-minimum-time-to-reach-destination/description/?envType=daily-question&envId=2024-07-28
 */
public class SecondMinimum {
    public static void main(String[] args) {
        SecondMinimum secondMinimum = new SecondMinimum();
        int n = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int time = 3, change = 5;
        System.out.println(secondMinimum.secondMinimum(n, edges, time, change));
    }

    private int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 1});
        d1[1] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int frequency = current[1];

            int timePassed = (frequency == 1) ? d1[node] : d2[node];
            if (d2[node] != Integer.MAX_VALUE && node == n) {
                return d2[n];
            }

            int multiplication = timePassed / change;
            if (multiplication % 2 == 1) {// Red light
                timePassed = change * (multiplication + 1); // to set green
            }
            for (int neighbor : adjacencyList.get(node)) {
                if (d1[neighbor] == Integer.MAX_VALUE) {
                    d1[neighbor] = timePassed + time;
                    queue.offer(new int[] {neighbor, 1});
                } else if (d2[neighbor] == Integer.MAX_VALUE && d1[neighbor] != timePassed + time) {
                    d2[neighbor] = timePassed + time;
                    queue.offer(new int[] {neighbor, 2});
                }
            }
        }
        return -1;
    }
}