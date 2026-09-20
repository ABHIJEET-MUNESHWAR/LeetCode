class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] result = new int[1];
        averageOfSubtree(root, result);
        return result[0];
    }

    private int[] averageOfSubtree(TreeNode node, int[] result) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] leftSubTree = averageOfSubtree(node.left, result);
        int[] rightSubTree = averageOfSubtree(node.right, result);
        int currentSum = leftSubTree[0] + rightSubTree[0] + node.val;
        int currentCount = leftSubTree[1] + rightSubTree[1] + 1;
        if (currentSum / currentCount == node.val) {
            result[0]++;
        }
        return new int[] { currentSum, currentCount };
    }
}