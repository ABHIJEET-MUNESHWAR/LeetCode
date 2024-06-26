class Solution {
    int mod = 1000000007;
    List<List<Integer>> adj = Arrays.asList(
            Arrays.asList(4, 6),
            Arrays.asList(6, 8),
            Arrays.asList(7, 9),
            Arrays.asList(4, 8),
            Arrays.asList(3, 9, 0),
            Arrays.asList(),
            Arrays.asList(1, 7, 0),
            Arrays.asList(2, 6),
            Arrays.asList(1, 3),
            Arrays.asList(2, 4));

    public int knightDialer(int n) {

        int result = 0;
        int[][] dp = new int[n][10];
        // State definition: dp[i][j] = Total number of distinct phone numbers of length
        // i when we start from cell j
        for (int i = 0; i <= 9; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int cell = 0; cell <= 9; cell++) {
                int answer = 0;
                for (int neighbour : adj.get(cell)) {
                    answer = (answer + dp[i - 1][neighbour]) % mod;
                }
                dp[i][cell] = answer;
            }
        }
        for (int cell = 0; cell <= 9; cell++) {
            result = (result + dp[n - 1][cell]) % mod;
        }
        return result;
    }
}