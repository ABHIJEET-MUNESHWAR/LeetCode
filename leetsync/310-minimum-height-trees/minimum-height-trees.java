class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        int[] degrees = new int[n];
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
            degrees[u]++;
            degrees[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.add(i);
            }
        }
        while (n > 2) {
            int queueSize = queue.size();
            n -= queueSize;
            while (queueSize-- > 0) {
                int v = queue.poll();
                for (int u : adjacencyList.get(v)) {
                    degrees[u]--;
                    if (degrees[u] == 1) {
                        queue.add(u);
                    }
                }
            }
        }
        result.addAll(queue);
        return result;
    }
}