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
        if (rank[parentOfI] > rank[parentOfJ]) {
            parent[parentOfJ] = parentOfI;
        } else if (rank[parentOfI] < rank[parentOfJ]) {
            parent[parentOfI] = parentOfJ;
        } else {
            parent[parentOfI] = parentOfJ;
            rank[parentOfJ]++;
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j, parent, rank);
                }
            }
        }
        int totalGroups = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                totalGroups++;
            }
        }
        return n - totalGroups;
    }
}