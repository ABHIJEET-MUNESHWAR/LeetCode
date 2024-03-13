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

    List<Location> locations = new ArrayList<>();

    class Location implements Comparable<Location> {
        int x, y, value;

        public Location(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Location l) {
            if (this.x != l.x) {
                return Integer.compare(this.x, l.x);
            } else if (this.y != l.y) {
                return Integer.compare(l.y, this.y);
            } else {
                return Integer.compare(this.value, l.value);
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(locations);
        int x = locations.get(0).x;
        answer.add(new ArrayList<>());
        for (Location location : locations) {
            if (x != location.x) {
                x = location.x;
                answer.add(new ArrayList<>());
            }
            answer.get(answer.size() - 1).add(location.value);
        }
        return answer;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root != null) {
            locations.add(new Location(x, y, root.val));
            dfs(root.left, x - 1, y - 1);
            dfs(root.right, x + 1, y - 1);
        }
    }
}