package com.leetcode.medium.graph;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-03-2025
    Time:   07:50 pm
    2685. Count the Number of Complete Components
    https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=daily-question&envId=2025-03-22
*/

import java.util.*;

public class CountCompleteComponentsDSU {
    public static void main(String[] args) {
        CountCompleteComponentsDSU ccc = new CountCompleteComponentsDSU();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(ccc.countCompleteComponents(n, edges));
    }

    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, Integer> edgeCount = new HashMap<>();
        int result = 0;
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            dsu.union(u, v);
        }
        for (int[] edge : edges) {
            int parent = dsu.find(edge[0]);
            edgeCount.put(parent, edgeCount.getOrDefault(parent, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                int v = dsu.size[i];
                int e = edgeCount.getOrDefault(i, 0);
                if ((v * (v - 1) / 2) == e) {
                    result++;
                }
            }
        }
        return result;
    }
}

class DSU {
    int[] parent, size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int a, int b) {
        int parentOfA = find(a);
        int parentOfB = find(b);
        if (parentOfA == parentOfB) {
            return;
        }
        if (size[parentOfA] > size[parentOfB]) {
            parent[parentOfB] = parentOfA;
            size[parentOfA] += size[parentOfB];
        } else {
            parent[parentOfA] = parentOfB;
            size[parentOfB] += size[parentOfA];
        }
    }
}