/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode, TreeNode> childToParentMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        assignParent(root);
        bfs(root, target, k);
        return result;
    }

    private void bfs(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(target);
        visited.add(target.val);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (currentLevel == k) {
                    result.add(node.val);
                }
                if (node.left != null && !visited.contains(node.left.val)) {
                    queue.add(node.left);
                    visited.add(node.left.val);
                }
                if (node.right != null && !visited.contains(node.right.val)) {
                    queue.add(node.right);
                    visited.add(node.right.val);
                }
                if (childToParentMap.containsKey(node) && !visited.contains(childToParentMap.get(node).val)) {
                    queue.add(childToParentMap.get(node));
                    visited.add(childToParentMap.get(node).val);
                }
            }
            currentLevel++;
        }
    }

    private void assignParent(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            childToParentMap.put(root.left, root);
        }
        assignParent(root.left);
        if (root.right != null) {
            childToParentMap.put(root.right, root);
        }
        assignParent(root.right);
    }
}