class Solution {
    public int findTheWinner(int n, int k) {
        return solve(n, k) + 1;
    }

    private int solve(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k + solve(n - 1, k)) % n;
    }
}