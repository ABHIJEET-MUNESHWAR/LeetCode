class Solution {
    public int uniquePaths(int m, int n) {
        return solve(m, n, 0, 0);
    }

    private int solve(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        return solve(m, n, i + 1, j) + solve(m, n, i, j + 1);
    }
}