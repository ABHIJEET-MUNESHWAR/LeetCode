class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int weight = time[2];
            adj.get(u).add(new int[] { v, weight });
        }
        int[] minDistances = new int[n + 1];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[k] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[] { 0, k });
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentWeight = current[0];
            int currentNode = current[1];
            if (currentWeight > minDistances[currentNode]) {
                continue;
            }
            for (int[] next : adj.getOrDefault(currentNode, new ArrayList<>())) {
                int nextNode = next[0];
                int nextWeight = next[1];
                if (minDistances[nextNode] > (nextWeight + minDistances[currentNode])) {
                    minDistances[nextNode] = nextWeight + minDistances[currentNode];
                    minHeap.add(new int[] { minDistances[nextNode], nextNode });
                }
            }
        }
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, minDistances[i]);
        }
        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }
}