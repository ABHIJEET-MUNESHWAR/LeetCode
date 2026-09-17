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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        
        List<List<Integer>> lists = new ArrayList<>();
        zigZagLevelOrderTraversal(lists, root, 0);
        return lists;
      }

      private void zigZagLevelOrderTraversal(List<List<Integer>> lists, TreeNode root, int level) {
        if (root == null) {
          return;
        }
        int size = lists.size();
        if (size <= level) {
          lists.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
          lists.get(level).add(root.val);
        } else {
          lists.get(level).add(0, root.val);
        }
        zigZagLevelOrderTraversal(lists, root.left, level + 1);
        zigZagLevelOrderTraversal(lists, root.right, level + 1);
      }
}