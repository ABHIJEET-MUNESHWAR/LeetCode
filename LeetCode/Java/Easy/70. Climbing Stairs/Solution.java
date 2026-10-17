class Solution {
    public int climbStairsRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    public int climbStairs(int n) {
        return climbStairsRecursive(n);
    }
}