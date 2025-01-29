class DSU {
    private int[] rank;
    private int[] parent;

    public DSU(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j) {
        int parentOfI = find(i);
        int parentOfJ = find(j);
        if (parentOfI == parentOfJ) {
            return;
        }
        if (rank[parentOfI] > rank[parentOfJ]) {
            parent[parentOfJ] = parent[parentOfI];
        } else if (rank[parentOfI] < parent[parentOfJ]) {
            parent[parentOfI] = parent[parentOfJ];
        } else {
            parent[parentOfI] = parent[parentOfJ];
            rank[parentOfJ]++;
        }
    }
}

class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        DSU dsu = new DSU(m);
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            if (dsu.find(i) == dsu.find(j)) {
                return edge;
            }
            dsu.union(i, j);
        }
        return new int[0];
    }
}