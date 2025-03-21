
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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int result = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> nums = new ArrayList<>();
            while (n-- > 0) {
                TreeNode node = q.poll();
                nums.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result += countMinSwapToSort(nums);
        }
        return result;
    }

    public int countMinSwapToSort(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap();
        int swaps = 0;
        List<Integer> sortNums = new ArrayList<>(nums);
        Collections.sort(sortNums);
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            map.put(nums.get(i), i);
        }
        for (int i = 0; i < n; i++) {
            if (sortNums.get(i).equals(nums.get(i))) {
                continue;
            }
            int currentIndex = map.get(sortNums.get(i));
            map.put(nums.get(i), currentIndex);
            map.put(nums.get(currentIndex), i);
            Collections.swap(nums, currentIndex, i);
            swaps++;
        }
        return swaps;
    }
}