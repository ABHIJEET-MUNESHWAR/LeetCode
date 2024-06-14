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

    public int minScore(int n, int[][] roads) {
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int minPath = Integer.MAX_VALUE;
        for (int[] road : roads) {
            union(road[0], road[1], parent, rank);
        }
        int parentOfZero = find(1, parent);
        for (int[] road : roads) {
            int parentOfRoad = find(road[0], parent);
            if (parentOfRoad == parentOfZero) {
                minPath = Math.min(minPath, road[2]);
            }
        }
        return minPath;
    }
}