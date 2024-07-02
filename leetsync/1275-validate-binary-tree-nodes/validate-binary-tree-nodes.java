class Solution {

    private int[] parent;
    private int components;

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private boolean union(int par, int child) {
        int childParent = find(child);
        if (childParent != child) {
            return false;
        }

        int parentParent = find(par);
        if (parentParent == childParent) {
            return false;
        }

        parent[child] = par;
        components--;
        return true;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        components = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1 && !union(i, leftChild[i])) {
                return false;
            }
            if (rightChild[i] != -1 && !union(i, rightChild[i])) {
                return false;
            }
        }

        return components == 1;
    }
}