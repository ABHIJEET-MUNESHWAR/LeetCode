/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class FindElements {
    Set<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        bfs(root, 0);
    }

    public void bfs(TreeNode root, int value) {
        Queue<TreeNode> q = new LinkedList<>();
        root.val = value;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            set.add(current.val);
            if (current.left != null) {
                current.left.val = current.val * 2 + 1;
                q.add(current.left);
            }
            if (current.right != null) {
                current.right.val = current.val * 2 + 2;
                q.add(current.right);
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */