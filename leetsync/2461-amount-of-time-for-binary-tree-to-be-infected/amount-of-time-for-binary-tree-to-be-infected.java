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
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        int maxDistance = 0;
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        buildAdjacencyMap(root, -1, adjacencyMap);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int neighbour : adjacencyMap.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            maxDistance++;
        }
        return maxDistance - 1;
    }

    private void buildAdjacencyMap(TreeNode root, int parent, Map<Integer, List<Integer>> adjacencyMap) {
        if (root == null) {
            return;
        }
        if (parent != -1) {
            adjacencyMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(parent);
        }
        if (root.left != null) {
            adjacencyMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
        }
        if (root.right != null) {
            adjacencyMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
        }
        buildAdjacencyMap(root.left, root.val, adjacencyMap);
        buildAdjacencyMap(root.right, root.val, adjacencyMap);
    }
}