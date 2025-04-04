package com.leetcode.medium.tree;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   04-04-2025
    Time:   09:57 pm
    🟠 1123. Lowest Common Ancestor of Deepest Leaves
    https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/?envType=daily-question&envId=2025-04-04
*/

import com.leetcode.utils.TreeNode;

public class LcaDeepestLeaves {
    class Pair {
        int depth;
        TreeNode node;

        Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }
        Pair l = solve(root.left);
        Pair r = solve(root.right);

        if (l.depth == r.depth) {
            return new Pair(l.depth + 1, root);
        } else if (l.depth > r.depth) {
            return new Pair(l.depth + 1, l.node);
        } else {
            return new Pair(r.depth + 1, r.node);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return solve(root).node;
    }
}
