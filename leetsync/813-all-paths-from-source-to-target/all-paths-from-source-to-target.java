class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(0);
        dfs(0, graph.length - 1, graph, current, result);
        return result;
    }

    private void dfs(int source, int destination, int[][] graph, List<Integer> current, List<List<Integer>> result) {
        if (source == destination) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int v : graph[source]) {
            current.add(v);
            dfs(v, destination, graph, current, result);
            current.remove(current.size() - 1);
        }
    }
}