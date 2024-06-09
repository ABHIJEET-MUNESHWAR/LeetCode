class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjacencyList = (ArrayList<Integer>[]) new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];
            adjacencyList[v].add(u);
            inDegree[u]++;
        }
        return topologicalSort(adjacencyList, numCourses, inDegree);
    }

    private int[] topologicalSort(ArrayList<Integer>[] adjacencyList, int numCourses, int[] inDegree) {
        int[] result = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int j = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                count++;
                result[j++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adjacencyList[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                    count++;
                    result[j++] = v;
                }
            }
        }
        if (count == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}