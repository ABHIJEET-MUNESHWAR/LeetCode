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
    public int countPairs(TreeNode root, int distance) {
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