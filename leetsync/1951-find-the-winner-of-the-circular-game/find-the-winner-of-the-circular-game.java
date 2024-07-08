class Solution {
    private int solve(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int index = solve(n - 1, k);
        index = (index + k) % n;
        return index;
    }

    public int findTheWinner(int n, int k) {
        return solve(n, k) + 1;
    }
}