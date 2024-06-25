class Solution {
    public int integerBreak(int n) {
        return solveRecursion(n, 1);
    }

    private int solveRecursion(int n, int index) {
        if (index >= n) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i = index; i <= n - 1; i++) {
            int product = i * Math.max(n - i, solveRecursion(n - i, i));
            result = Math.max(result, product);
        }
        return result;
    }
}