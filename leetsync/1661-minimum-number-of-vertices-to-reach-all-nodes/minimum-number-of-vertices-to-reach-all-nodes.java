class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> answer = new ArrayList<>();
        int[] visited = new int[n];
        for (List<Integer> edge : edges) {
            visited[edge.get(1)] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                answer.add(i);
            }
        }
        return answer;
    }
}