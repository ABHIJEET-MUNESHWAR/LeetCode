package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/07/24,
 * Time:    9:39 pm
 * 2196. Create Binary Tree From Descriptions
 * https://leetcode.com/problems/create-binary-tree-from-descriptions/description/?envType=daily-question&envId=2024-07-15
 */
public class CreateBinaryTree {
    public static void main(String[] args) {
        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        int[][] descriptions = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        TreeNode head = createBinaryTree.createBinaryTree(descriptions);
        head.inorderTraversal(head);
    }

    private TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        // Create nodes and set up parent-child relationships
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;
            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));
            if (isLeft) {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }
            childSet.add(child);
        }

        // Find the root node (which is not any child)
        for (int[] description : descriptions) {
            int parent = description[0];
            if (!childSet.contains(parent)) {
                return map.get(parent);
            }
        }
        return null;
    }
}