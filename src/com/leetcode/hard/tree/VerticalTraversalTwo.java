package com.leetcode.hard.tree;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   12-04-2025
    Time:   05:04 pm
    987. Vertical Order Traversal of a Binary Tree
    https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
*/

import com.leetcode.utils.ListUtils;
import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalTraversalTwo {
    public static void main(String[] args) {
        VerticalTraversalTwo verticalTraversal = new VerticalTraversalTwo();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ListUtils.printLists(verticalTraversal.verticalTraversal(root));
    }

    private List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    result.get(result.size() - 1).add(pq.poll());
                }
            }
        }
        return result;
    }

    public void dfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int x, int y) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).add(root.val);
        dfs(root.left, map, x - 1, y + 1);
        dfs(root.right, map, x + 1, y + 1);
    }
}
