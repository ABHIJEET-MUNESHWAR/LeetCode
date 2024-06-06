class Solution {

    public int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    public void union(int i, int j, int[] parent, int[] rank) {
        int parentOfI = find(i, parent);
        int parentOfJ = find(j, parent);
        if (parentOfI == parentOfJ) {
            return;
        }
        if (rank[parentOfI] > rank[parentOfJ]) {
            parent[parentOfJ] = parentOfI;
        } else if (rank[parentOfI] < rank[parentOfJ]) {
            parent[parentOfI] = parentOfJ;
        } else {
            parent[parentOfI] = parentOfJ;
            rank[parentOfI]++;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        int[] parent = new int[size + 1];
        int[] rank = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int[] edge : edges) {
            if (find(edge[0], parent) == find(edge[1], parent)) {
                return edge;
            }
            union(edge[0], edge[1], parent, rank);
        }
        return new int[] { -1, -1 };
    }
}