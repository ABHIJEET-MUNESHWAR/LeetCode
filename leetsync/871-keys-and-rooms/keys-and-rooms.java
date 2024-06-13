class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int totalRooms = rooms.size();
        boolean[] visited = new boolean[totalRooms];
        dfs(rooms, 0, visited);
        for (int i = 1; i < totalRooms; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int source, boolean[] visited) {
        visited[source] = true;
        for (int next : rooms.get(source)) {
            if (!visited[next]) {
                dfs(rooms, next, visited);
            }
        }
    }
}