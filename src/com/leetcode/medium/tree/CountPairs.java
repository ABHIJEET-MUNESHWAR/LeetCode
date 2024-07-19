package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    18/07/24,
 * Time:    8:13 pm
 * 1530. Number of Good Leaf Nodes Pairs
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/description/?envType=daily-question&envId=2024-07-18
 */
public class CountPairs {
    public static void main(String[] args) {
        CountPairs countPairs = new CountPairs();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        int distance = 3;
        System.out.println(countPairs.countPairs(root, distance));
        System.out.println(countPairs.countPairsDfs(root, distance));
    }

    private int countPairsDfs(TreeNode root, int distance) {
        int[] goodLeafNodes = new int[1];
        solve(root, distance, goodLeafNodes);
        return goodLeafNodes[0];
    }

    private List<Integer> solve(TreeNode root, int distance, int[] goodLeafNodes) {
        if (root == null) {
            List<Integer> emptyList = new ArrayList<>();
            emptyList.add(0);
            return emptyList;
        }
        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        List<Integer> leftDistance = solve(root.left, distance, goodLeafNodes);
        List<Integer> rightDistance = solve(root.right, distance, goodLeafNodes);
        for (int l : leftDistance) {
            for (int r : rightDistance) {
                if (r != 0 && l != 0 && (r + l) <= distance) {
                    goodLeafNodes[0]++;
                }
            }
        }
        List<Integer> currentDistances = new ArrayList<>();
        for (int l : leftDistance) {
            if (l != 0 && (l + 1) <= distance) {
                currentDistances.add(l + 1);
            }
        }
        for (int r : rightDistance) {
            if (r != 0 && (r + 1) <= distance) {
                currentDistances.add(r + 1);
            }
        }
        return currentDistances;
    }

    private int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> adjacencyMap = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();

        buildGraph(root, null, adjacencyMap, leafNodes);

        int count = 0;

        for (TreeNode leafNode : leafNodes) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            queue.add(leafNode);
            visited.add(leafNode);

            for (int level = 0; level <= distance; level++) {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    if (node != leafNode && leafNodes.contains(node)) {
                        count++;
                    }
                    for (TreeNode child : adjacencyMap.getOrDefault(node, new ArrayList<>())) {
                        if (!visited.contains(child)) {
                            queue.add(child);
                            visited.add(child);
                        }
                    }
                }
            }
        }
        return count / 2;
    }

    private void buildGraph(TreeNode root, TreeNode previous, Map<TreeNode, List<TreeNode>> adjacencyMap, Set<TreeNode> leafNodes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafNodes.add(root);
        }
        if (previous != null) {
            adjacencyMap.computeIfAbsent(root, k -> new ArrayList<>()).add(previous);
            adjacencyMap.computeIfAbsent(previous, k -> new ArrayList<>()).add(root);
        }
        buildGraph(root.left, root, adjacencyMap, leafNodes);
        buildGraph(root.right, root, adjacencyMap, leafNodes);
    }
}