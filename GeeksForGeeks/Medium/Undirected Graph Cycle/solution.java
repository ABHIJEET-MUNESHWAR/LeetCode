class Solution {
    public boolean isCycleDfs(Map<Integer, List<Integer>> adj, int V, int u, int parent, boolean[] isVisited){
        isVisited[u] = true;
        for(int v: adj.getOrDefault(u, new ArrayList<>())){
            if(v==parent){
                continue;
            }
            if(isVisited[v]){
                return true;
            }
            if(isCycleDfs(adj, V, v, u, isVisited)){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, key->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, key->new ArrayList<>()).add(u);
        }
        boolean[] isVisited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!isVisited[i] && isCycleDfs(adj, V, i, -1, isVisited)){
                return true;
            }
        }
        return false;
    }
}