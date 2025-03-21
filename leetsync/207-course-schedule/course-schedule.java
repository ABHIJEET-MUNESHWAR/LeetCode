class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjacencyList = (ArrayList<Integer>[]) new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList[v].add(u);
            inDegree[u]++;
        }
        return topologicalSortCheck(numCourses, adjacencyList, inDegree);
    }

    private boolean topologicalSortCheck(int numCourses, ArrayList<Integer>[] adjacencyList, int[] inDegree) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                count++;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adjacencyList[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}