class Solution {

    class TrieNode {
        TrieNode left;
        TrieNode right;
    }

    public void insert(TrieNode root, int data) {
        TrieNode crawl = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (data >> i) & 1;
            if (bit == 0) {
                if (crawl.left == null) {
                    crawl.left = new TrieNode();
                }
                crawl = crawl.left;
            } else {
                if (crawl.right == null) {
                    crawl.right = new TrieNode();
                }
                crawl = crawl.right;
            }
        }
    }

    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        TrieNode root = new TrieNode();
        for (int num : nums) {
            insert(root, num);
        }
        for (int num : nums) {
            maxXor = Math.max(maxXor, maxXor(root, num));
        }
        return maxXor;
    }

    private int maxXor(TrieNode root, int num) {
        int maxXor = 0;
        TrieNode crawl = root;
        for (int i = 31; i >= 0; i--) {
            int ithBit = (num >> i) & 1;
            if (ithBit == 1) {
                if (crawl.left != null) {
                    maxXor += Math.pow(2, i);
                    crawl = crawl.left;
                } else {
                    crawl = crawl.right;
                }
            } else {
                if (crawl.right != null) {
                    maxXor += Math.pow(2, i);
                    crawl = crawl.right;
                } else {
                    crawl = crawl.left;
                }
            }
        }
        return maxXor;
    }
}