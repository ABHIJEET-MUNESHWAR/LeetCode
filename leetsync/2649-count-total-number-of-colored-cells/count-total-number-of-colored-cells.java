class Solution {
    public long coloredCells(int n) {
        long cells = 1 + 2 * ((long)n * ((long)n - 1));
        return cells;
    }
}