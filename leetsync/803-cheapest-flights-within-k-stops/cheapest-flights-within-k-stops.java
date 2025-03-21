class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] minDistances = new int[n];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], cost = flight[2];
            adj.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[] { to, cost });
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { src, 0 });
        minDistances[src] = 0;
        int level = 0;
        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentNode = queue.poll();
                int u = currentNode[0], d = currentNode[1];
                List<int[]> neighbors = adj.getOrDefault(u, Collections.emptyList());
                for (int[] neighbor : neighbors) {
                    int to = neighbor[0], cost = neighbor[1];
                    if (minDistances[to] > (cost + d)) {
                        minDistances[to] = cost + d;
                        queue.add(new int[] { to, d + cost });
                    }
                }
            }
            level++;
        }
        return minDistances[dst] == Integer.MAX_VALUE ? -1 : minDistances[dst];
    }
}