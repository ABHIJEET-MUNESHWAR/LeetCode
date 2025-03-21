class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int totalRooms = rooms.size();
    boolean[] visited = new boolean[totalRooms];
    //dfs(rooms, 0, visited);
    bfs(rooms, 0, visited);
    for (int i = 1; i < totalRooms; i++) {
      if (!visited[i]) {
        return false;
      }
    }
    return true;
  }

  private void bfs(List<List<Integer>> rooms, int source, boolean[] visited) {
    visited[source] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        for (int next : rooms.get(cur)) {
          if (!visited[next]) {
            queue.add(next);
            visited[next] = true;
          }
        }
      }
    }
  }
}