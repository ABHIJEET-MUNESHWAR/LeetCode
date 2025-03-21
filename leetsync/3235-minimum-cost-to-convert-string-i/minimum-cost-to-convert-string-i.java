class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] distances = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        floydWarshall(original, changed, distances, cost);
        Long result = 0L;
        int n = source.length();
        for (int i = 0; i < n; i++) {
            int sourceNode = source.charAt(i) - 'a';
            int targetNode = target.charAt(i) - 'a';
            if (sourceNode == targetNode) {
                continue;
            }
            if (distances[sourceNode][targetNode] == Integer.MAX_VALUE) {
                return -1;
            }
            result += distances[sourceNode][targetNode];
        }
        return result;
    }

    private void floydWarshall(char[] original, char[] changed, long[][] distances, int[] cost) {
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            int source = original[i] - 'a';
            int destination = changed[i] - 'a';
            distances[source][destination] = Math.min((long) cost[i], distances[source][destination]);
        }
        for (int via = 0; via < 26; via++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][via] + distances[via][j]);
                }
            }
        }
    }
}