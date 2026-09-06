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

    public long countPairs(int n, int[][] edges) {
        Map<Integer, Integer> componentVsSizeMap = new HashMap<>();
        int[] parents = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 0;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1], parents, rank);
        }
        for (int i = 0; i < n; i++) {
            int parentOfI = find(i, parents);
            componentVsSizeMap.put(parentOfI, componentVsSizeMap.getOrDefault(parentOfI, 0) + 1);
        }
        long remaining = n;
        long result = 0L;
        for (Map.Entry<Integer, Integer> entry : componentVsSizeMap.entrySet()) {
            long componentSize = entry.getValue();
            result += componentSize * (remaining - componentSize);
            remaining -= componentSize;
        }
        return result;
    }
}