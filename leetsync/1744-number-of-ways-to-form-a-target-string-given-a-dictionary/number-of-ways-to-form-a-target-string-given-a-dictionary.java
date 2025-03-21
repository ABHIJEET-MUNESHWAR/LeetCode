class Solution {
    private int m;
    private int k;
    private final int MOD = (int) 1e9 + 7;
    private int[][] memo;

    private int solve(int i, int j, long[][] freq, String target) {
        if (i == m) {
            return 1;
        }

        if (j == k) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int notTaken = solve(i, j + 1, freq, target) % MOD;

        int taken = (int) ((freq[target.charAt(i) - 'a'][j] * solve(i + 1, j + 1, freq, target)) % MOD);

        return memo[i][j] = (notTaken + taken) % MOD;
    }

    public int numWays(String[] words, String target) {
        k = words[0].length();
        m = target.length();

        long[][] freq = new long[26][k];

        // Populate frequency array
        for (String word : words) {
            for (int col = 0; col < k; col++) {
                freq[word.charAt(col) - 'a'][col]++;
            }
        }

        memo = new int[m][k];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, freq, target);
    }
}