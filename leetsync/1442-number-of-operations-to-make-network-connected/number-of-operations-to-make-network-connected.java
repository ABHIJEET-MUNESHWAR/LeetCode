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
            rank[parentOfJ]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int size = connections.length;
        if (size < (n - 1)) {
            return -1;
        }
        int[] parents = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
            rank[i] = 0;
        }
        int components = n;
        for (int[] connection : connections) {
            if (find(connection[0], parents) != find(connection[1], parents)) {
                union(connection[0], connection[1], parents, rank);
                components--;
            }
        }
        return components - 1;
    }
}