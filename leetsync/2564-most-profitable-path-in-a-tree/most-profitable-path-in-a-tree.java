//Approach-1 (DFS for Bob and DFS for Alice)
//T.C : O(n)
//S.C : O(n)
class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Map<Integer, Integer> bobMap = new HashMap<>();
    int aliceIncome;

    boolean DFSBob(int current, int time, boolean[] visited) {
        visited[current] = true;
        bobMap.put(current, time);

        if (current == 0) {
            return true; // Reached target
        }

        for (int ngbr : adj.getOrDefault(current, new ArrayList<>())) {
            if (!visited[ngbr]) {
                if (DFSBob(ngbr, time + 1, visited)) {
                    return true;
                }
            }
        }
        bobMap.remove(current);
        return false;
    }

    void DFSAlice(int current, int time, int income, boolean[] visited, int[] amount) {
        visited[current] = true;
        if (!bobMap.containsKey(current) || time < bobMap.get(current)) {
            income += amount[current];
        } else if (time == bobMap.get(current)) {
            income += (amount[current]) / 2;
        }
        if (adj.getOrDefault(current, new ArrayList<>()).size() == 1 && current != 0) {
            // Leaf Node
            aliceIncome = Math.max(aliceIncome, income);
        }
        /*
         * {1} -> (2, 3)
         * 2 -> 1
         * 3 -> 1,....
         * (1) ---- (2)
         * |
         * |
         * (3)------.....
         */
        for (int ngbr : adj.getOrDefault(current, new ArrayList<>())) {
            if (!visited[ngbr]) {
                DFSAlice(ngbr, time + 1, income, visited, amount);
            }
        }
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length; // n nodes (0 to n-1)
        aliceIncome = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        // DFS on Bob for finding time to reach each node till 0
        int time = 0;
        boolean[] visited = new boolean[n];
        DFSBob(bob, time, visited);

        int income = 0;
        Arrays.fill(visited, false);
        DFSAlice(0, 0, income, visited, amount);

        return aliceIncome;
    }
}