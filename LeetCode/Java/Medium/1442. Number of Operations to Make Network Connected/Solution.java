class Solution {
    public int find(int i, int[] parent) {
        if (i == parent[i]) {
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
        if (rank[parentOfI] < rank[parentOfJ]) {
            parent[parentOfI] = parentOfJ;
        } else if (rank[parentOfI] > rank[parentOfJ]) {
            parent[parentOfJ] = parentOfI;
        } else {
            parent[parentOfJ] = parentOfI;
            rank[parentOfI]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int components = n;
        for (int[] connection : connections) {
            int i = connection[0];
            int j = connection[1];
            int parentOfI = find(i, parent);
            int parentOfJ = find(j, parent);
            if (parentOfI != parentOfJ) {
                union(i, j, parent, rank);
                components--;
            }
        }
        return components - 1;
    }
}