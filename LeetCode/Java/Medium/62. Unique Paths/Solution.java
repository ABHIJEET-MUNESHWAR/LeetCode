class Solution {
    public int uniquePathsRecursion(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        return uniquePathsRecursion(m, n, i + 1, j) + uniquePathsRecursion(m, n, i, j + 1);
    }

    public int uniquePaths(int m, int n) {
        return uniquePathsRecursion(m, n, 0, 0);
    }
}