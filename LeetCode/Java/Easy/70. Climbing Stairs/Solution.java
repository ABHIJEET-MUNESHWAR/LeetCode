class Solution {
    public int climbStairsRecursion(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
    }

    public int climbStairs(int n) {
        return climbStairsRecursion(n);
    }
}