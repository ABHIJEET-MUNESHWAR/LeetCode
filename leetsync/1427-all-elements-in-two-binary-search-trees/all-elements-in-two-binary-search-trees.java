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
    PriorityQueue<Integer> pq = new PriorityQueue<>();// We are using the default natural sorting order, to sort the
                                                      // value

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();// resultant ArrayList

        if (root1 == null && root2 == null)// if we are provided with both the null graph
            return ans;// returning the empty ArrayList

        inorder(root1);// recursive inorder tree 1
        inorder(root2);// recursive inorder tree 2

        while (!pq.isEmpty())// putting the result into the ArrayList
            ans.add(pq.poll());// Ascendinly sorted

        return ans;// returning the ArrayList contain the node sorted in ascending order
    }

    public void inorder(TreeNode root) {// simple inorder, inorder of BST is always sorted
        if (root == null)// when we reach to the null node we just return
            return;
        inorder(root.left);// recursing down the left subtree
        pq.offer(root.val);// Dealing with the root, adding then to the PriorityQueue
        inorder(root.right);// recursing down the left subtree
        return;// all function complete deleting this activation record and returning to the
               // parent
    }
}