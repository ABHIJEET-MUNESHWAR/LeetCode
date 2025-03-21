class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // 1. Prepare adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        int[] result = new int[n];
        int[] count = new int[26];
        dfs(adjacencyList, 0, -1, result, labels, count);
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> adjacencyList, int current, int parent, int[] result, String labels,
            int[] count) {
        char currentLabel = labels.charAt(current);
        int countBeforeVisitingCurrentChildren = count[currentLabel - 'a'];
        // Now I'll explore
        count[currentLabel - 'a']++;
        for (int child : adjacencyList.get(current)) {
            if (child == parent) {
                continue;
            }
            dfs(adjacencyList, child, current, result, labels, count);
        }
        // Now we'll update after variable
        int countAfterVisitingCurrentChildren = count[currentLabel - 'a'];
        result[current] = countAfterVisitingCurrentChildren - countBeforeVisitingCurrentChildren;
    }
}