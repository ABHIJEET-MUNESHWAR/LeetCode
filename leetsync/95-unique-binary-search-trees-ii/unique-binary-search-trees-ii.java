/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode>[][] dp; // dp[start][end] stores the list of all unique BSTs that can be
                           // formed using values from start to end.

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // Initialize dp array
        dp = new List[n + 1][n + 1];
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null); // Base case: return null for empty subtree
            return result;
        }

        // Check if result for this range is already computed
        if (dp[start][end] != null) {
            return dp[start][end];
        }

        // Generate all possible BSTs for current range [start, end]
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubtrees = generateTrees(i + 1, end);

            // Combine left and right subtrees with current root i
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        // Memoize the result
        dp[start][end] = result;
        return result;
    }
}