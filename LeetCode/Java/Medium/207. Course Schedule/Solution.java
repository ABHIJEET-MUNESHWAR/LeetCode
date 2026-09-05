class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!visited[i] && isCycleDFS(adj, visited, inRecursion, i)){
                return false;
            }
        }
        return true;
    }
    public boolean isCycleDFS(Map<Integer, ArrayList<Integer>> adj, boolean[] visited, boolean[] inRecursion, int u){
        visited[u]=true;
        inRecursion[u]=true;
        for(int v: adj.get(u)){
            if(!visited[v] && isCycleDFS(adj, visited, inRecursion, v)){
                return true;
            } else if(inRecursion[v]){
                return true;
            }
        }
        inRecursion[u]=false;
        return false;
    }
}