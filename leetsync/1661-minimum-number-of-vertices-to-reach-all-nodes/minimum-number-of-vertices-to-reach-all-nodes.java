class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (List<Integer> edge : edges) {
            visited.add(edge.get(1));
            if (!visited.contains(edge.get(0))) {
                result.add(edge.get(0));
            }
        }
        for (List<Integer> edge : edges) {
            if (result.contains(edge.get(1))) {
                result.remove(edge.get(1));
            }
        }
        List<Integer> answer = new ArrayList<>();
        answer.addAll(result);
        return answer;
    }
}